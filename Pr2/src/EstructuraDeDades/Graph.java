package EstructuraDeDades;

import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<V, E> implements GraphInterface<V, E>{
    private HashMap<Integer, V> vertices; // will be using V's hashCode as key for each entry
    private AdjVertex<E>[] edges;
    private int numEdges;

    public Graph(List<V> vertices){
        createGraph(vertices);
    }

    /**
     * CrearGraf: Constructor per inicialitzar la taula
     *
     * @param vertices llista de V per afegir al graf
     */
    @SuppressWarnings("unchecked")
    public void createGraph(List<V> vertices) {
        this.vertices = new HashMap<>();
        numEdges = 0;
        edges = new AdjVertex[vertices.size()];
        for (V elem : vertices){ // adding the vertices to the graph
            addVertex(elem);
        }
    }

    /**
     * afegirAresta: funció per afegir una aresta
     *
     * @param v1 V amb la que s'afegirà l'aresta
     * @param v2 V amb la que s'afegirà l'aresta
     * @param e etiqueta de tipus E
     * @throws CannotAddElement en cas que no es pugui afegir
     */
    public void addEdge(V v1, V v2, E e) throws CannotAddElement {
        // is v1 or v2 already in the graph?
        if((!vertices.containsKey(v1.hashCode())) || (!vertices.containsKey(v2.hashCode()))) {
            throw new CannotAddElement();
        }

        if(v1.equals(v2)) throw new CannotAddElement();

        if(!edgeExists(v1, v2)) {
            // relations between vertices will be stored in one of each reference:
            // for instance, if a vertex v2 is found first in the adjVertex table,
            // we will store the new edge (which is a new instance of AdjVertex) in
            // its corresponding "next_row" reference and then v1 (which is supposed
            // to be found in a greater position in the table than v2) will store
            // the new edge in its corresponding "next_col"
            // Also worth mentioning that all "next_row" and "next_col" relations
            // will be saved in the same order their vertices appear in the table
            AdjVertex<E> newEdge;

            int v1Pos = getPosVertex(v1.hashCode());
            int v2Pos = getPosVertex(v2.hashCode());

            if (v1Pos < v2Pos) { // position matters so that we know on which references to store
                                 // the edge info
                newEdge = new AdjVertex<>(v1.hashCode(), v2.hashCode());
                establishEdgeRelation(newEdge, v1Pos, v2Pos);
            } else {
                newEdge = new AdjVertex<>(v2.hashCode(), v1.hashCode());
                establishEdgeRelation(newEdge, v2Pos, v1Pos);
            }
            newEdge.setTag(e);
        }
        else{
            throw new CannotAddElement();
        }
    }

    /**
     * existeixAresta: funció que ens diu si una aresta existeix
     *
     * @param v1 V amb la que es comprova si existeix l'aresta
     * @param v2 V amb la que es comprova si existeix l'aresta
     * @return true si existeix l'aresta, false si no
     */
    public boolean edgeExists(V v1, V v2) {
        try {
            return edgeValue(v1, v2) != null;
        } catch (NonExistentEdge e) {

        }
        return false;
    }

    /**
     * valorAresta: funció que retorna el valor d'una aresta
     *
     * @param v1 V amb la que es comprova si el valor l'aresta
     * @param v2 V amb la que es comprova si el valor l'aresta
     * @return el valor E d'una aresta
     * @throws NonExistentEdge en cas que no existeixi
     */
    public E edgeValue(V v1, V v2) throws NonExistentEdge {
        int v1Pos = getPosVertex(v1.hashCode());
        int v2Pos = getPosVertex(v2.hashCode());

        // to avoid ArrayOutOfBoundsException
        if(v1Pos == -1 || v2Pos == -1)
            return null;

        AdjVertex<E> temp;
        if (v1Pos < v2Pos){ // position once again matters, so we know through which reference we should look for
            temp = edges[v1Pos];
            // look through next_row for a match with the lower position vertex
            while(temp.next_row != null){
                if(temp.next_row.getCode_col() == v2.hashCode())
                    return temp.next_row.getTag();
                temp = temp.next_row;
            }
        }
        else{
            temp = edges[v2Pos];
            // look through next_row for a match with the higher position vertex
            while (temp.next_row != null) {
                if (temp.next_row.getCode_col() == v1.hashCode())
                    return temp.next_row.getTag();
                temp = temp.next_row;
            }
        }
        throw new NonExistentEdge();
    }

    /**
     * adjacents: funció que retorna una llista que conté tots els nodes
     *          adjacents al node passat per paràmetre
     *
     * @param v V amb la que es busca els nodes adjacents
     * @return una llista que conté tots els nodes adjacents a un node
     * @throws NotFound en cas que no es pugui crear aquesta llista
     */
    public List<V> adjacent(V v) throws NotFound {
        if(!vertices.containsValue(v))
            throw new NotFound();

        List<V> result = new ArrayList<>();

        int pos = getPosVertex(v.hashCode());
        AdjVertex<E> temp = edges[pos];
        while(temp.next_col != null){
            result.add(vertices.get(temp.next_col.getCode_row()));
            temp = temp.next_col;
        }
        temp = edges[pos];
        while(temp.next_row != null){
            result.add(vertices.get(temp.next_row.getCode_col()));
            temp = temp.next_row;
        }
        return result;
    }

    private boolean isFull(AdjVertex<E>[] table, int elems){
        return table.length == elems;
    }

    @SuppressWarnings("unchecked")
    private void expandTable(){
        AdjVertex<E>[] resized = new AdjVertex[edges.length * 2];
        System.arraycopy(edges, 0, resized, 0, edges.length);
        edges = resized;
    }

    private void addVertex(V v){
        vertices.put(v.hashCode(), v);
        if (isFull(edges, numEdges)){
            expandTable();
        }
        // add v1 to the edge table
        edges[numEdges] = new AdjVertex<>(v.hashCode(), -1);
        numEdges++;
    }

    private int getPosVertex(int hash){
        for (int i = 0; i < edges.length; i++){
            if (edges[i].getCode_row() == hash)
                return i;
        }
        return -1;
    }

    private void establishEdgeRelation(AdjVertex<E> newEdge, int v1Pos, int v2Pos){
        // establish next_row relation
        AdjVertex<E> temp = edges[v1Pos];
        while((temp.next_row != null) && (getPosVertex(temp.next_row.getCode_col()) < v2Pos)){
            temp = temp.next_row;
        }

        if (temp.next_row == null){
            temp.next_row = newEdge;
            newEdge.next_row = null;
        }
        else{
            AdjVertex<E> oldNext = temp.next_row;
            temp.next_row = newEdge;
            newEdge.next_row = oldNext;
        }

        // establish next_col relation
        temp = edges[v2Pos];
        // loop downwards until finding the last
        while((temp.next_col != null) && (getPosVertex(temp.next_col.getCode_row()) < v1Pos)){
            temp = temp.next_col;
        }

        if (temp.next_col == null){
            temp.next_col = newEdge;
            newEdge.next_col = null;
        }
        else{
            AdjVertex<E> oldNext = temp.next_col;
            temp.next_col = newEdge;
            newEdge.next_col = oldNext;
        }
    }

    public void printGraph(){
        for (AdjVertex<E> vertex : edges){
            if(vertex == null)
                break;
            try {
                System.out.println(vertices.get(vertex.getCode_row()) + " " + adjacent(vertices.get(vertex.getCode_row())));
            }
            catch (NotFound e){
                e.printStackTrace();
            }
        }
    }
}

package EstructuraDeDades;

import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<V, E> implements GraphInterface<V, E>{
    HashMap<Integer, V> vertices; // will be using V's hashCode as key for each entry
    AdjVertex<E>[] edges;
    int numEdges;

    public Graph(){
        createGraph();
    }

    @SuppressWarnings("unchecked")
    public void createGraph() {
        vertices = new HashMap<>();
        numEdges = 0;
        edges = new AdjVertex[1];
    }

    public void addEdge(V v1, V v2, E e) throws CannotAddElement {
        // does v1 already exist in the hashmap?
        if(!vertices.containsKey(v1.hashCode())){
            addVertex(v1);
        }
        // is v2 already in the graph?
        if(!vertices.containsKey(v2.hashCode())) {
            // if it's not, add it to the map
            // add new position in the adjVertex table
            addVertex(v2);
        }

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

        if (v1Pos < v2Pos){
            newEdge = new AdjVertex<>(v1.hashCode(), v2.hashCode());
            establishEdgeRelation(newEdge, v1Pos, v2Pos);
        }
        else{
            if (v1Pos > v2Pos){
                newEdge = new AdjVertex<>(v2.hashCode(), v1.hashCode());
                establishEdgeRelation(newEdge, v2Pos, v1Pos);
            }
             else throw new CannotAddElement();
        }
        newEdge.setTag(e);
    }


    public boolean edgeExists(V v1, V v2) {
        try {
            return edgeValue(v1, v2) != null;
        } catch (NonExistentEdgeException e) {
            e.printStackTrace();
        }
        return false;
    }


    public E edgeValue(V v1, V v2) throws NonExistentEdgeException {
        // Option 1:
        // is v1 in the graph?
        // if not return false
        // is v2 in the graph?
        // if not return false
        // iterate through "edges" until finding v1 or v2 and look for the relation between both

        // Option 2:
        // look for v1 or v2, if one is found, iterate through its next_row and next_col
        // until finding null or existence of the relation

        int v1Pos = getPosVertex(v1.hashCode());
        int v2Pos = getPosVertex(v2.hashCode());

        // to avoid ArrayOutOfBoundsException
        if(v1Pos == -1 || v2Pos == -1)
            return null;

        AdjVertex<E> temp;
        if (v1Pos < v2Pos){
            temp = edges[v1Pos];
            while(temp.next_row != null){
                if(temp.next_row.getCode_col() == v2.hashCode())
                    return temp.next_row.getTag();
                temp = temp.next_row;
            }
        }
        else{
            temp = edges[v2Pos];
            while (temp.next_row != null) {
                if (temp.next_row.getCode_col() == v1.hashCode())
                    return temp.next_row.getTag();
                temp = temp.next_row;
            }
        }
        throw new NonExistentEdgeException();
    }


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


    public List<String> optimalPath(String id_origen, String id_destination, int range){


//    openSet = start;
//
//    String[] cameFrom = new String[n];
//
//    int[] gScore = new int[n];
//    Arrays.fill(gScore, Integer.MAX_VALUE);
//    gScore[start] = 0;
//
//    int[] fScore = new int[n];
//    Arrays.fill(fScore, Integer.MAX_VALUE);
//    fScore[start] = heuristicFunc(start);
//
//    while (openSet != null){
//        current = openSet[lowestScore()];
//
//        if (current == goal)
//            return reconstruct_path(cameFrom, current);
//
//        openSet.remove(current);
//        for (neighbor: current) {
//            tentative_gScore = gScore[current] + d(current, neighbor);
//
//            if(tentative_gScore < gScore[neighbor]){
//                cameFrom[neighbor] = current;
//                gScore[neighbor] = tentative_gScore;
//                fScore[neighbor] = tentative_gScore + h(neighbor);
//                if (neighbor not in openSet)
//                    openSet.add(neighbor);
//            }
//        }
//    }
//    throw new Exception();
        return null;
    }

    public List<String> notGuaranteedMaxDistanceZones(String id_origen, int range){
        return null;
    }

    /**
     *
     *
     * @param v
     */
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

    @SuppressWarnings("unchecked")
    private void expandTable(){
        AdjVertex<E>[] resized = new AdjVertex[edges.length * 2];
        System.arraycopy(edges, 0, resized, 0, edges.length);
        edges = resized;
    }

    private boolean isFull(AdjVertex<E>[] table, int elems){
        return table.length == elems;
    }

    /**
     * v1pos < v2pos
     *
     * @param newEdge
     * @param v1Pos
     * @param v2Pos
     */
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
}

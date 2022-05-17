package EstructuraDeDades;

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
        edges = new AdjVertex[numEdges];
    }


    public void addEdge(V v1, V v2, E e) {
        // does v1 already exist in the hashmap?
        if(!vertices.containsKey(v1.hashCode())){
            vertices.put(v1.hashCode(), v1);
            // add a position to the adjVertex table
            if (isFull(edges, numEdges)){
                expandTable();
            }
            // add v1 to the edge table
        }

        // is v2 already in the graph?
            // if it's not, add it to the map
            // add new position in the adjVertex table

        /* create bigger edge table */
        /* some code here */

        // relations between vertices will be stored in one of each reference:
        // for instance, if a vertex v2 is found first in the adjVertex table,
        // we will store the new edge (which is a new instance of AdjVertex) in
        // its "next_row" reference and then v1 (which is supposed to be found in
        // a greater position in the table than v2) will store the new edge in "next_col"

    }


    public boolean edgeExists(V v1, V v2) {
        // Option 1:
            // is v1 in the graph?
                // if not return false
            // is v2 in the graph?
                // if not return false
            // iterate through "edges" until finding v1 or v2 and look for the relation between both

        // Option 2:
            // look for v1 or v2, if one is found, iterate through its next_row and next_col
            // until finding null or existence of the relation
        return false;
    }


    public E edgeValue(V v1, V v2) {
        // if v1 or v2 doesn't exist throw new Exception
        // else, look for both until finding one then iterate through the next_row and next_col
        // and return the value
        return null;
    }


    public List<V> adjacent(V v) {
        // is v in the graph?
            // if not throw exception
        // iterate through "edges" until finding a "next" relation to v
        return null;
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
    }

    public List<String> notGuaranteedMaxDistanceZones(String id_origen, int range){
        return null;
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
}

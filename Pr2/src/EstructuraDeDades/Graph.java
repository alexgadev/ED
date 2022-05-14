package EstructuraDeDades;


import java.util.HashMap;
import java.util.List;

public class Graph<V> implements GraphInterface<V>{
    HashMap<String, List<V>> vertices;
    AdjVertex[] edges;

    public void createGraph() {
        vertices = new HashMap<>();
        edges = new AdjVertex[vertices.size()];
    }


    public void addEdge(V v1, V v2, AdjVertex e) {

    }


    public boolean edgeExists(V v1, V v2) {
        return false;
    }


    public AdjVertex edgeValue(V v1, V v2) {
        return null;
    }


    public List<V> adjacent(V v) {
        return null;
    }

    List<String> optimalPath(String id_origen, String id_destination, int range){



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

    List<String> notGuaranteedMaxDistanceZones(String id_origen, int range){
        return null;
    }
}

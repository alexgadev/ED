package EstructuraDeDades;

import java.util.List;

public interface GraphInterface<V> {

    void createGraph();

    void addEdge(V v1, V v2, AdjVertex e);

    boolean edgeExists(V v1, V v2);

    AdjVertex edgeValue(V v1, V v2);

    List<V> adjacent(V v);
}

package EstructuraDeDades;

import java.util.List;

public interface GraphInterface<V, E> {

    void createGraph();

    void addEdge(V v1, V v2, E e);

    boolean edgeExists(V v1, V v2);

    E edgeValue(V v1, V v2);

    List<V> adjacent(V v);
}

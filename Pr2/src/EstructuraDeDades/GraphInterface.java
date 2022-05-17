package EstructuraDeDades;

import Exceptions.CannotAddElement;
import Exceptions.NonExistentEdgeException;
import Exceptions.NotFound;

import java.util.List;

public interface GraphInterface<V, E> {

    void createGraph();

    void addEdge(V v1, V v2, E e) throws CannotAddElement;

    boolean edgeExists(V v1, V v2);

    E edgeValue(V v1, V v2) throws NonExistentEdgeException;

    List<V> adjacent(V v) throws NotFound;
}

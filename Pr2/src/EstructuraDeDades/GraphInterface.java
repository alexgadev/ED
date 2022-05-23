package EstructuraDeDades;

import Exceptions.CannotAddElement;
import Exceptions.NonExistentEdge;
import Exceptions.NotFound;

import java.util.List;

public interface GraphInterface<V, E> {

    void createGraph(List<V> vertices);

    void addEdge(V v1, V v2, E e) throws CannotAddElement;

    boolean edgeExists(V v1, V v2);

    E edgeValue(V v1, V v2) throws NonExistentEdge;

    List<V> adjacent(V v) throws NotFound;
}

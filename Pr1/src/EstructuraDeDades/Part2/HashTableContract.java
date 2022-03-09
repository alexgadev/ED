package EstructuraDeDades.Part2;

import EstructuraDeDades.Part1.DoublyLinkedList;
import Exceptions.*;

public interface HashTableContract<K extends Comparable<K>, T extends Comparable<T>> {

    void create(int dim);

    void insert(K key, T data) throws SizeException;

    T get(K key) throws NotFound;

    int search(K key) throws SearchNotFound;

    int size();

    void remove(K key) throws NotFound;

    DoublyLinkedList<T> getValues();

    DoublyLinkedList<K> getKeys();

    float getLoadFactor();
}

package EstructuraDeDades;

import java.util.List;

public interface HashTableContract<K extends Comparable<K>, T extends Comparable<T>> {

    void create();

    void insert(K key, T data);

    T get(K key);

    int search(K key);

    int size();

    void remove(K key);

    DoublyLinkedList<T> getValues();

    DoublyLinkedList<K> getKeys();

    float getLoadFactor();
}

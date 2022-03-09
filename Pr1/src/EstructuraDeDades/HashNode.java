package EstructuraDeDades;

public class HashNode<K, T extends Comparable<T>> {
    K key;
    T value;
    HashNode<K, T> next;

    public HashNode(K key, T value){
        this.key = key;
        this.value = value;
    }
}

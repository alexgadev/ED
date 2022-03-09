package EstructuraDeDades.Part2;

public class HashNode<K, T extends Comparable<T>> {
    K key;
    T value;
    HashNode<K, T> next;

    public HashNode(K key, T value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return "Key [" + key + "]\tValue [" + value + "]";
    }
}

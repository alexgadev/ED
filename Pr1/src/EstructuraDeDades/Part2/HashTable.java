package EstructuraDeDades.Part2;

import EstructuraDeDades.Part1.DoublyLinkedList;
import Exceptions.*;

import java.util.Arrays;

public class HashTable<K extends Comparable<K>, T extends Comparable<T>> implements HashTableContract<K, T>{
    HashNode<K, T>[] hashTable;

    @SuppressWarnings("unchecked")
    public void create() {
        hashTable = new HashNode[50];
        Arrays.fill(hashTable, null);
    }

    /**
     * Hash Function
     *
     * @param key
     * @return
     */
    public int hashFunc(K key){
        long sum = 0;
        long mul = 1;

        String keyAsString = (String) key;

        for(int i = 0; i < keyAsString.length(); i++){
            mul = (i % 4 == 0) ? 1 : mul * 256;
            sum += keyAsString.charAt(i) * mul;
        }
        return (int) (Math.abs(sum) % hashTable.length);
    }

    /**
     *
     *
     * @param key
     * @param data
     */
    public void insert(K key, T data) {
        int index = hashFunc(key);
        HashNode<K, T> node = new HashNode<>(key, data);

        if (hashTable[index] == null){ // not a collision
            hashTable[index] = node;
        }
        else{
            HashNode<K, T> temp = hashTable[index];

            while ((temp.next != null) && (temp.key.compareTo(key) != 0)){
                temp = temp.next;
            }

            if(temp.key.compareTo(key) == 0) {
                temp.value = data;
            }
            else {
                temp.next = node;
                node.next = null;
            }
        }
    }

    /**
     *
     *
     * @param key
     * @return
     * @throws NotFound
     */
    public T get(K key) throws NotFound{
        int index = hashFunc(key);

        HashNode<K, T> node = hashTable[index];

        while((node != null) && (node.key.compareTo(key) != 0)){
            node = node.next;
        }

        if(node == null) {
            throw new NotFound();
        }

        return node.value;
    }

    /**
     *
     *
     * @param key
     * @return
     * @throws SearchNotFound
     */
    public int search(K key) throws SearchNotFound {
        int index = hashFunc(key);
        HashNode<K, T> node = hashTable[index];

        int cost = 1;

        while(node != null) {
            if (node.key.compareTo(key) != 0) {
                cost++;
            }
            else {
                return cost;
            }
            node = node.next;
        }

        throw new SearchNotFound(cost);
    }

    /**
     *
     *
     * @return
     */
    public int size() {
        int size = 0;
        for (HashNode<K, T> ktHashNode : hashTable) {
            if (ktHashNode != null) {
                size++;

                HashNode<K, T> node = ktHashNode;
                while (node.next != null) {
                    node = node.next;
                    size++;
                }
            }
        }
        return size;
    }

    /**
     *
     *
     * @param key
     * @throws NotFound
     */
    public void remove(K key) throws NotFound {
        int index = hashFunc(key);

        HashNode<K, T> node = hashTable[index];

        if (node == null)
            throw new NotFound();

        if (node.key.compareTo(key) == 0)
            hashTable[index] = node.next;
        else
            while((node.next != null) && (node.next.key.compareTo(key) != 0)){
                node = node.next;
            }
            if(node.next == null)
                throw new NotFound();

            if(node.next.key.compareTo(key) == 0) {
                node.next = node.next.next;
            }
    }


    public DoublyLinkedList<T> getValues() {
        DoublyLinkedList<T> values = new DoublyLinkedList<>();
        values.create();

        for (int i = 0; i < hashTable.length; i++){
            HashNode<K, T> node = hashTable[i];

            while(node != null){
                values.insert(node.value);
                node = node.next;
            }
        }

        return values;
    }


    public DoublyLinkedList<K> getKeys() {
        DoublyLinkedList<K> keys = new DoublyLinkedList<>();
        keys.create();

        for (int i = 0; i < hashTable.length; i++){
            HashNode<K, T> node = hashTable[i];

            while(node != null){
                keys.insert(node.key);
                node = node.next;
            }
        }
        return keys;
    }

    /**
     *
     *
     * @return
     */
    public float getLoadFactor() {
        return ((float) size()) / hashTable.length;
    }

    public void showTable(){
        for (HashNode<K, T> ktHashNode : hashTable) {
            if (ktHashNode != null) {
                HashNode<K, T> node = ktHashNode;
                while (node != null) {
                    System.out.println(node);
                    node = node.next;
                }
            }
        }
    }
}
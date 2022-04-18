package EstructuraDeDades.Part2;

import EstructuraDeDades.Part1.DoublyLinkedList;
import Exceptions.*;

import java.util.Arrays;

public class HashTable<K extends Comparable<K>, T extends Comparable<T>> implements HashTableContract<K, T>{
    private HashNode<K, T>[] hashTable;
    private static final float MAX_LOAD = 0.75F;

    /**
     * Constructor de classe
     *
     * @param dim dimensió de la taula de hashing
     */
    public HashTable(int dim){
        create(dim);
    }

    /**
     * Crear: Constructor per inicialitzar la taula
     */
    @SuppressWarnings("unchecked")
    public void create(int dim) {
        hashTable = new HashNode[dim];
        Arrays.fill(hashTable, null);
    }

    /**
     * Funció de hashing (String folding)
     *
     * @param key K per obtenir un índex de la taula de hashing
     * @return índex de la taula de hashing
     */
    private int hashFunc(int size, K key){
        long sum = 0;
        long mul = 1;

        String keyAsString = key.toString();

        for(int i = 0; i < keyAsString.length(); i++){
            mul = (i % 4 == 0) ? 1 : mul * 256;
            sum += keyAsString.charAt(i) * mul;
        }
        return (int) (Math.abs(sum) % size);
    }

    /**
     * Inserir: insereix un element a la taula de Hash
     * si l'element ja existeix, actualitza el seu valor
     *
     * @param key clau que indexa l'informació
     * @param data informació a emmagatzemar
     * @throws SizeException excepció en cas que no es pugui inserir
     */
    public void insert(K key, T data) throws SizeException {
        float lf = getLoadFactor();

        if (lf > MAX_LOAD) {
            /*throw new SizeException();*/
            resize();
        }

        int index = hashFunc(hashTable.length, key);  // using hash function to get an index to the hash table
        HashNode<K, T> node = new HashNode<>(key, data);

        insertion(hashTable, index, node);
    }

    /**
     * Obtenir: retorna l'element que té la clau K
     *
     * @param key clau que indexa l'element que es vol obtenir
     * @return l'element que té la clau K
     * @throws NotFound excepció en cas que no es pugui obtenir
     */
    public T get(K key) throws NotFound{
        int index = hashFunc(hashTable.length, key);

        HashNode<K, T> node = hashTable[index];

        // traverse list as long as it doesn't reach the end, or it finds
        // the node that contains the same key as the argument
        while((node != null) && (node.key.compareTo(key) != 0)){
            node = node.next;
        }

        // while statement might have reached the end of the collision
        // without finding the key, or the index of the hash table was already null
        if(node == null) {
            throw new NotFound();
        }

        return node.value;
    }

    /**
     * Buscar: comprova si un element està a la taula
     *
     * @param key clau que indexa l'element a buscar
     * @return Cost de l'operació. Nombre d'elements que s'hagin accedit
     * @throws SearchNotFound excepció en cas que l'element no s'hagi trobat, conté
     * informació del nombre d'elements que s'han accedit per comprovar si l'element existeix o no
     */
    public int search(K key) throws SearchNotFound {
        int index = hashFunc(hashTable.length, key);
        HashNode<K, T> node = hashTable[index];

        int cost = 1; // just by visiting first node we'll count as one access

        while(node != null) {
            if (node.key.compareTo(key) != 0) { // add until to the total cost if it's not the key we are searching for
                cost++;
            }
            else {
                return cost;
            }
            node = node.next;
        }

        throw new SearchNotFound(cost); // reaching here means it didn't find the key and reached the end of the list
    }

    /**
     * Mida: nombre d'elements que conté la taula
     *
     * @return el nombre d'elements que conté la taula en aquest moment
     */
    public int size() {
        int size = 0;
        // each existing node different from null will count as an element in the hash table
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
     * Esborrar: esborra un element de la taula
     *
     * @param key clau que indexa l'element a esborrar
     * @throws NotFound excepció en cas que l'element no s'hagi trobat
     */
    public void remove(K key) throws NotFound {
        int index = hashFunc(hashTable.length, key);

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

    /**
     * ObtenirValors: obtenir una llista amb tots els valors de la taula
     *
     * @return una llista amb tots els valors de la taula
     */
    public DoublyLinkedList<T> getValues() {
        DoublyLinkedList<T> values = new DoublyLinkedList<>();

        for (HashNode<K, T> ktHashNode : hashTable) {
            HashNode<K, T> node = ktHashNode;

            while (node != null) {
                values.insert(node.value);
                node = node.next;
            }
        }
        return values;
    }

    /**
     * ObtenirClaus: obtenir una llista amb totes les claus de la taula
     *
     * @return una llista amb totes les claus de la taula
     */
    public DoublyLinkedList<K> getKeys() {
        DoublyLinkedList<K> keys = new DoublyLinkedList<>();

        for (HashNode<K, T> ktHashNode : hashTable) {
            HashNode<K, T> node = ktHashNode;

            while (node != null) {
                keys.insert(node.key);
                node = node.next;
            }
        }
        return keys;
    }

    /**
     * ObtenirFactorDeCàrrega: factor de càrrega actual
     *
     * @return el factor de càrrega actual
     */
    public float getLoadFactor() {
        return ((float) size()) / hashTable.length;
    }


    private void insertion(HashNode<K, T>[] table, int index, HashNode<K, T> node){
        if (table[index] == null) { // not a collision
            table[index] = node;
        } else {
            HashNode<K, T> temp = table[index];

            // comparing temp.next to null instead of temp with null to get
            // the last node so that we can assign its ".next" to the new node if needed
            while ((temp.next != null) && (temp.key.compareTo(node.key) != 0)) {
                temp = temp.next;
            }
            // in case the key already exists, just update its value
            if (temp.key.compareTo(node.key) == 0) {
                temp.value = node.value;
            } else {
                temp.next = node;
                node.next = null;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        HashNode<K, T>[] resized = new HashNode[hashTable.length * 2];
        Arrays.fill(resized, null);

        for (HashNode<K, T> node : hashTable) {
            while (node != null) {
                HashNode<K, T> temp = new HashNode<>(node.key, node.value);
                int index = hashFunc(resized.length, temp.key);

                insertion(resized, index, temp);

                node = node.next;
            }
        }

        hashTable = resized;
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
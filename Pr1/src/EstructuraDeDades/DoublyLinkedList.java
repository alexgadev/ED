package EstructuraDeDades;

import Exceptions.*;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements DLL<T>, Iterable<T> {
    private Node<T> first, last;

    /**
     * Crear: constructor per inicialitzar la llista
     *
     */
    public void create() {
        first=last=null;
    }

    /**
     * Inserir: insereix un element al final de la llista
     *
     * @param data T que es vol inserir a la llista
     */
    public void insert(T data) {
        Node<T> node = new Node<>(data);
        // look if the list is empty
        if (last == null) { // same as comparing if first == null
            first = node;
            last = node;
            node.prev = null;
            node.next = null;
        }
        else { // if list is not empty, add at the end of the list
            node.prev = last;
            node.next = null;
            last.next = node;
            last = node;
        }
    }

    /**
     * Inserir: insereix un element a la llista en la posició indicada
     *
     * @param pos enter on es es vol inserir l'element
     * @param data T que es vol inserir a la llista
     * @throws SizeException
     */
    public void insert(int pos, T data) throws SizeException{
        Node<T> node = first;
        Node<T> newNode = new Node<>(data);

        if (pos > this.size()) {
            throw new SizeException();
        }
        else {
            int n = 0;
            while (n < pos) {
                node = node.next;
                n++;
            }

            newNode.next = node;
            if (node.prev == null) {
                newNode.prev = null;
                first = newNode;
            } else {
                newNode.prev = node.prev;
                node.prev.next = newNode;
            }
            node.prev = newNode;
        }
    }

    /**
     * Obtenir: retorna l'element que hi ha en una determinada posició
     *
     * @param pos posició on es troba l'element
     * @return l'element que hi ha en una determinada posició
     * @throws NotFound excepció en cas que no es pugui obtenir
     */
    public T get(int pos) throws NotFound {
        Node<T> node = first;
        int count = 0;
        while(count < pos){
            count++;
            node = node.next;
        }

        if ((count == pos) && (node != null)){
            return node.data;
        }else throw new NotFound();
    }

    /**
     * Nombre d'elements que conté la llista
     *
     * @return el nombre d'elements que conté la llista en aquest moment
     */
    public int size() {
        Node<T> node = first;
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }

    /**
     * Esborrar: esborra un element de la llista en una posició determinada
     *
     * @param pos integer on es troba l'element a esborrar
     * @throws NotFound llença l'excepció en cas que no es pugui eliminar
     */
    public void remove(int pos) throws NotFound{
        Node<T> target = first;
        int n = 0;
        while(n < pos){ // get target node in position == pos
            n++;
            target = target.next;
        }

        if ((n == pos) && (target != null)){
            if (target.prev == null)    // if target position is the first node then we don't
                first = target.next;    // need to reassign prev node's next pointer
            else
                target.prev.next = target.next; // any other position will reassign prev node's next pointer

            if (target.next == null)    // if target position is the last node then we don't need to
                last = target.prev;     // reassign next node's prev pointer
            else
                target.next.prev = target.prev; // any other position will reassign next node's prev pointer
        } else throw new NotFound();
    }

    /**
     * Buscar: comprova si un element està a la llista
     *
     * @param data T que es vol buscar
     * @return cost de l'operació, nombre d'elements que s'han accedit per tal de comprovar si l'element existeix o no.
     * @throws SearchNotFound excepció en cas que l'element no s'hagi trobat, contindrà informació del nombre d'elements que s'han accedit.
     */
    public int search(T data) throws SearchNotFound {
        Node<T> node = first;
        int cost = 1;

        T val = node.data;

        while((val.compareTo(data) != 0) && (node != null)) {
            node = node.next;
            if(node != null)
                val = node.data;
                cost++;
        }

        if(node == null)
            throw new SearchNotFound(cost);

        if (val.compareTo(data) == 0){
            return cost;
        } else throw new SearchNotFound(cost);
    }

    @Override
    public Iterator<T> iterator(){
        return new TIterator<>(this);
    }
}

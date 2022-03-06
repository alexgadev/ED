package EstructuraDeDades;

import Exceptions.NotFound;
import Exceptions.SearchNotFound;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements DLL<T>, Iterator<T> {
    private Node<T> first, last;

    /**
     *
     *
     */
    public void create() {
        first=last=null;
    }

    /**
     *
     *
     * @param data
     */
    public void insert(T data) {
        Node<T> node = new Node<T>(data);
        // look if the list is empty
        if (last == null) { // same as comparing if first == null
            first = node;
            last = node;
            node.prev = null;
            node.next = null;
        }
        else {
            node.prev = last;
            node.next = null;
            last.next = node;
            last = node;
        }
    }

    /**
     *
     *
     * @param pos
     * @param data
     */
    public void insert(int pos, T data) {
        Node<T> node = first;
        Node<T> newNode = new Node<>(data);

        int n = 0;
        while (n < pos){
            node = node.next;
            n++;
        }

        newNode.next = node;
        if (node.prev == null){
            newNode.prev = null;
            first = newNode;
        }
        else {
            newNode.prev = node.prev;
            node.prev.next = newNode;
        }
        node.prev = newNode;
        //TODO: control possible exceptions
    }

    /**
     *
     *
     * @param pos
     * @return
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
     *
     *
     * @return
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
     *
     *
     * @param pos
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


    public int search(T data) throws SearchNotFound {
        Node<T> temp = first;
        int cost = 0;

        while(temp.data.compareTo(data) != 0){
            cost++;
            temp = temp.next;
            if (temp == null)
                break;
        }
        
        if ((temp.data.compareTo(data) == 0) && (temp != null)){
            return cost;
        } else throw new SearchNotFound(cost);
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}

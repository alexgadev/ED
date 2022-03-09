package EstructuraDeDades.Part1;

import Exceptions.NotFound;

import java.util.Iterator;

public class TIterator<T extends Comparable<T>> implements Iterator<T> {
    private DoublyLinkedList<T> list;
    private int posIterator;

    public TIterator(DoublyLinkedList<T> list){
        this.list = list;
        posIterator = 0;
    }

    @Override
    public boolean hasNext() {
        return posIterator < list.size();
    }

    @Override
    public T next() {
        T aux = null;
        try {
            aux = list.get(posIterator);
        } catch (NotFound e) {
            e.printStackTrace();
        }
        posIterator++;
        return aux;
    }
}

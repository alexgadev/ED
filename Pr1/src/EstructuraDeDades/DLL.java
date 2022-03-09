package EstructuraDeDades;

import Exceptions.*;

public interface DLL<T extends Comparable<T>> {

    void create();

    void insert(T data);

    void insert(int pos, T data) throws SizeException;

    T get(int pos) throws NotFound;

    int size();

    void remove(int pos) throws NotFound;

    int search(T data) throws SearchNotFound;
}

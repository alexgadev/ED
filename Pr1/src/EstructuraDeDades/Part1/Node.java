package EstructuraDeDades.Part1;

public class Node<T extends Comparable<T>> {
    Node<T> next, prev;
    T data;

    public Node (T data){
        this.data = data;
    }

    @Override
    public String toString() {return "Node [data= " + data + "]";}
}

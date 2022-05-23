package Exceptions;

public class NonExistentEdge extends Exception{
    private static final long serialVersionUID=1L;

    public NonExistentEdge() { super("Error : L'aresta no existeix");}
}

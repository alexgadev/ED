package Exceptions;

public class NonExistentEdgeException extends Exception{
    private static final long serialVersionUID=1L;

    public NonExistentEdgeException() { super("Error : L'aresta no existeix");}
}

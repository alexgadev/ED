package Exceptions;

public class NotFound extends Exception{
    private static final long serialVersionUID=1L;

    public NotFound() { super("Error : No s'ha pogut trobar l'element");}
}

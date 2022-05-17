package Exceptions;

public class CannotAddElement extends Exception{
    private static final long serialVersionUID=1L;

    public CannotAddElement(){ super("Error : No es pot afegir l'element.");}
}

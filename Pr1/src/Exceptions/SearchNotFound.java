package Exceptions;

public class SearchNotFound extends Exception{
    private static final long serialVersionUID=1L;

    public SearchNotFound(int n) { super("Error : No s'ha trobat l'element\nS'han accedit a " + n + " elements"); }
}

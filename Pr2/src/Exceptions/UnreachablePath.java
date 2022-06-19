package Exceptions;

public class UnreachablePath extends Exception{
    private static final long serialVersionUID=1L;

    public UnreachablePath(){ super("Error : No es pot arribar al node especificat.");}
}

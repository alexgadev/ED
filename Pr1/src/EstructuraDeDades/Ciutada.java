package EstructuraDeDades;

public class Ciutada implements Comparable<Ciutada> {
    String Nom;
    String Cognom;
    String DNI;

    @Override
    public int compareTo(Ciutada o) {
        return DNI.compareTo(o.DNI);
    }
}

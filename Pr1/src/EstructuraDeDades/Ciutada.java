package EstructuraDeDades;

public class Ciutada implements Comparable<Ciutada> {
    private final String Nom;
    private final String Cognom;
    private final String DNI;

    public Ciutada(String n, String c, String d){
        Nom = n;
        Cognom = c;
        DNI = d;
    }

    public String getNom() {
        return Nom;
    }

    public String getCognom() {
        return Cognom;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public int compareTo(Ciutada o) {
        return getDNI().compareTo(o.getDNI());
    }

    @Override
    public String toString(){return "Nom: " + Nom + "\tCognom: " + Cognom + "\tDNI: " + DNI;}
}

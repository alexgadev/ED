package EstructuraDeDades;

public class Endoll implements Comparable<Endoll>{
    private int id, temps;
    private double consum;
    private String estat, tipus;

    public Endoll(int id, double consum, int temps, String estat, String tipus) {
        this.id = id;
        this.consum = consum;
        this.temps = temps;
        this.estat = estat;
        this.tipus = tipus;
    }

    public int getId() {
        return id;
    }

    public double getConsum() {
        return consum;
    }

    public int getTemps() {
        return temps;
    }

    public String getEstat() {
        return estat;
    }

    public String getTipus() {
        return tipus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConsum(double consum) {
        this.consum = consum;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Override
    public int compareTo(Endoll o) {
        return getId() == o.getId() ? 0 : -1;
    }

    @Override
    public String toString() {
        return "Endoll{" +
                "id=" + id +
                ", temps=" + temps +
                ", consum=" + consum +
                ", estat='" + estat + '\'' +
                ", tipus='" + tipus + '\'' +
                '}';
    }
}

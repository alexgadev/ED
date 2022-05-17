package EstructuraDeDades;

public class Endoll implements Comparable<Endoll>{
    private int id, consum, temps;
    private String estat, tipus;

    public Endoll(int id, int consum, int temps, String estat, String tipus) {
        this.id = id;
        this.consum = consum;
        this.temps = temps;
        this.estat = estat;
        this.tipus = tipus;
    }

    public int getId() {
        return id;
    }

    public int getConsum() {
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

    public void setConsum(int consum) {
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
}

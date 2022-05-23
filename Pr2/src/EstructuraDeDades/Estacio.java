package EstructuraDeDades;

import EstructuraDeDades.Part1.DoublyLinkedList;

public class Estacio {
    private int id_estacio;
    private String nom, data, ciutat, carrer;
    private double potencia,  latitud, longitud;
    private DoublyLinkedList<Endoll> endolls;

    public Estacio(int id_estacio, double potencia, String nom, String data, String carrer,
                   String ciutat, double latitud, double longitud, DoublyLinkedList<Endoll> endolls) {
        this.id_estacio = id_estacio;
        this.potencia = potencia;
        this.nom = nom;
        this.data = data;
        this.ciutat = ciutat;
        this.carrer = carrer;
        this.latitud = latitud;
        this.longitud = longitud;
        this.endolls = endolls;
    }

    public int getId_estacio() {
        return id_estacio;
    }

    public double getPotencia() {
        return potencia;
    }

    public String getNom() {
        return nom;
    }

    public String getData() {
        return data;
    }

    public String getCarrer() {
        return carrer;
    }

    public String getCiutat() {
        return ciutat;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setId_estacio(int id_estacio) {
        this.id_estacio = id_estacio;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setEndolls(DoublyLinkedList<Endoll> endolls) {
        this.endolls = endolls;
    }

    public DoublyLinkedList<Endoll> getEndolls() {
        return endolls;
    }

    @Override
    public String toString() {
        return "Estacio{" +
                "id_estacio=" + id_estacio +
                ", nom='" + nom + '\'' +
                ", data='" + data + '\'' +
                ", ciutat='" + ciutat + '\'' +
                ", carrer='" + carrer + '\'' +
                ", potencia=" + potencia +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", endolls=" + endolls +
                '}';
    }
}

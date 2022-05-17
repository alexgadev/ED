package EstructuraDeDades;

import EstructuraDeDades.Part1.DoublyLinkedList;

public class Estacio {
    private int id_estacio, potencia;
    private String nom, data, ciutat;
    private float latitud, longitud;
    private DoublyLinkedList<Endoll> endolls;

    public Estacio(int id_estacio, int potencia, String nom, String data, String ciutat,
                   float latitud, float longitud, DoublyLinkedList<Endoll> endolls) {
        this.id_estacio = id_estacio;
        this.potencia = potencia;
        this.nom = nom;
        this.data = data;
        this.ciutat = ciutat;
        this.latitud = latitud;
        this.longitud = longitud;
        this.endolls = endolls;
    }

    public int getId_estacio() {
        return id_estacio;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getNom() {
        return nom;
    }

    public String getData() {
        return data;
    }

    public String getCiutat() {
        return ciutat;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setId_estacio(int id_estacio) {
        this.id_estacio = id_estacio;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void setEndolls(DoublyLinkedList<Endoll> endolls) {
        this.endolls = endolls;
    }

    public DoublyLinkedList<Endoll> getEndolls() {
        return endolls;
    }
}

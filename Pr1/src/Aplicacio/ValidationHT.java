package Aplicacio;

import EstructuraDeDades.Ciutada;
import EstructuraDeDades.Part1.DoublyLinkedList;
import EstructuraDeDades.Part2.HashTable;
import Exceptions.NotFound;
import Exceptions.SearchNotFound;

public class ValidationHT {
    public static void main(String[] args){
        HashTable<String, Ciutada> ciutadans = new HashTable<>();
        ciutadans.create();

        Ciutada c1 = new Ciutada("Kratos", "Lawrence", "19632780A");
        Ciutada c2 = new Ciutada("Elena", "Lawrence", "35970581F"); // same lastname as c1
        Ciutada c3 = new Ciutada("Jean", "Cooper", "12408979L");    // all different
        Ciutada c4 = new Ciutada("Ruby", "Campbell", "54368005F");  // same dni as c3
        Ciutada c5 = new Ciutada("Troy", "Alvarez", "89703330H");   // all different
        Ciutada c6 = new Ciutada("Luna", "Wong", "29309153T");      // same dni as c1

        ciutadans.insert(c1.getDNI(), c1);
        ciutadans.insert(c2.getDNI(), c2);
        ciutadans.insert(c3.getDNI(), c3);
        ciutadans.insert(c4.getDNI(), c4);
        ciutadans.insert(c5.getDNI(), c5);
        ciutadans.insert(c6.getDNI(), c6);

        System.out.println("List initially...");

        ciutadans.showTable();

        System.out.println("Getting key = 29309153T");
        try {
            System.out.println(ciutadans.get("29309153T"));
        }
        catch (NotFound e){
            e.printStackTrace();
        }

        System.out.println("List size: " + ciutadans.size());

        System.out.println("Trying to remove Ruby...");
        try{
            ciutadans.remove("54368005F");
        }
        catch (NotFound e){
            e.printStackTrace();
        }

        ciutadans.showTable();

        System.out.println("List size: " + ciutadans.size());

        System.out.println("Load Factor: " + ciutadans.getLoadFactor());

        try {
            System.out.println("Cost of searching for Luna's DNI: " + ciutadans.search("12408979L"));
        }
        catch (SearchNotFound e){
            System.out.println(e.getMessage());
        }

        DoublyLinkedList<Ciutada> l1 = ciutadans.getValues();
        for (Ciutada c:l1){
            System.out.println(c);
        }

        DoublyLinkedList<String> l2 = ciutadans.getKeys();
        for (String str:l2){
            System.out.println(str);
        }
    }
}

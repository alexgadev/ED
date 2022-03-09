package Aplicacio;

import EstructuraDeDades.Ciutada;
import EstructuraDeDades.Part1.DoublyLinkedList;
import EstructuraDeDades.Part2.HashTable;
import Exceptions.NotFound;
import Exceptions.SearchNotFound;
import Exceptions.SizeException;

public class ValidationHT {
    public static void main(String[] args){
        HashTable<String, Ciutada> ciutadans = new HashTable<>(100);

        Ciutada c1 = new Ciutada("Kratos", "Lawrence", "19632780A");
        Ciutada c2 = new Ciutada("Elena", "Lawrence", "35970581F");
        Ciutada c3 = new Ciutada("Jean", "Cooper", "12408979L");
        Ciutada c4 = new Ciutada("Ruby", "Campbell", "54368005F");
        Ciutada c5 = new Ciutada("Troy", "Alvarez", "89703330H");
        Ciutada c6 = new Ciutada("Luna", "Wong", "29309153T");

        try {
            ciutadans.insert(c1.getDNI(), c1);
            ciutadans.insert(c2.getDNI(), c2);
            ciutadans.insert(c3.getDNI(), c3);
            ciutadans.insert(c4.getDNI(), c4);
            ciutadans.insert(c5.getDNI(), c5);
            ciutadans.insert(c6.getDNI(), c6);
        }
        catch(SizeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("List initially...");

        ciutadans.showTable();

        System.out.println("Getting key = 29309153T");
        try {
            System.out.println(ciutadans.get("29309153T")); // Should print citizen Luna
        }
        catch (NotFound e){
            e.printStackTrace();
        }

        System.out.println("List size: " + ciutadans.size()); // size = 6

        System.out.println("Trying to remove Ruby...");
        try{
            ciutadans.remove("54368005F");
        }
        catch (NotFound e){
            System.out.println(e.getMessage());
        }

        ciutadans.showTable();

        System.out.println("List size: " + ciutadans.size()); // size = 5

        System.out.println("Load Factor: " + ciutadans.getLoadFactor()); // 5 / 100 = 0.05

        try {
            System.out.println("Cost of searching for Luna's DNI: " + ciutadans.search("29309153T")); // 2 at most
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

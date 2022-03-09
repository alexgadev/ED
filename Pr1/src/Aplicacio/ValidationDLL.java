package Aplicacio;

import EstructuraDeDades.*;
import EstructuraDeDades.Part1.DoublyLinkedList;
import Exceptions.*;

public class ValidationDLL {
    public static void main(String[] args){
        DoublyLinkedList<Ciutada> ciutadans = new DoublyLinkedList<>();
        ciutadans.create();

        Ciutada c1 = new Ciutada("Ruby", "Lawrence", "19632780A");
        Ciutada c2 = new Ciutada("Elena", "Lawrence", "35970581F"); // same lastname as c1
        Ciutada c3 = new Ciutada("Jean", "Cooper", "12408979L");    // all different
        Ciutada c4 = new Ciutada("Ruby", "Campbell", "12408979L");  // same dni as c2
        Ciutada c5 = new Ciutada("Troy", "Alvarez", "89703330H");   // all different
        Ciutada c6 = new Ciutada("Luna", "Wong", "19632780A");      // same dni as c1

        ciutadans.insert(c1);
        ciutadans.insert(c2);
        ciutadans.insert(c3);
        ciutadans.insert(c4);

        try{
            ciutadans.insert(2, c5);
            ciutadans.insert(1, c6);
        } catch (SizeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("List initially...");

        showList(ciutadans);

        System.out.println("Size: " + ciutadans.size()); // size = 6

        System.out.println("Trying to add to a position bigger than the list size...");

        try{
            ciutadans.insert(8, c4);
        }
        catch (SizeException s){
            System.out.println(s.getMessage());
        }

        System.out.println("Size after failed insertion: " + ciutadans.size()); // size = 6

        System.out.println("Removing first... ");

        try{
            ciutadans.remove(0);
        }
        catch (NotFound n){
            System.out.println(n.getMessage());
        }

        System.out.println("List after removing first element...");

        showList(ciutadans);

        System.out.println("Size after removing: " + ciutadans.size()); // size = 5

        try {
            System.out.println("Element at position = 4: " + ciutadans.get(4)); // Ruby Campbell 12408979L
            System.out.println("Element at position = 7: " + ciutadans.get(7)); // Error
        }
        catch(NotFound e){
            System.out.println(e.getMessage());
        }

        Ciutada cout = new Ciutada("Doesn't", "Belong", "Here");
        System.out.println("Searching for citizens Elena, Ruby and other citizen...");
        try{
            System.out.println("Items checked: " + ciutadans.search(c2)); // 2
            System.out.println("Items checked: " + ciutadans.search(c4)); // 4 as Ruby has the same DNI as Jean
            System.out.println("Items checked: " + ciutadans.search(cout)); // 5 and error as it doesn't belong to the citizens list
        } catch (SearchNotFound e){
            System.out.println(e.getMessage());
        }
    }

    public static <T extends Comparable<T>> void showList(DoublyLinkedList<T> l){
        // using foreach thanks to the iterator
        for (T elem:l){
            System.out.println(elem);
        }
    }
}

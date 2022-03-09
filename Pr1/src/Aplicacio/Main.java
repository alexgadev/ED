package Aplicacio;

import EstructuraDeDades.*;
import Exceptions.*;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.create();

        list.insert(256);
        list.insert(10);
        list.insert(20);
        list.insert(30);

        try {
            list.insert(2, 15);
            list.insert(1, 115);
        }
        catch (SizeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("List initially:");

        showList(list);

        System.out.println("Size: " + list.size());

        System.out.println("Removing first:");
        try{
            list.remove(0);
        } catch (NotFound e){
            System.out.println(e.getMessage());
        }

        showList(list);

        System.out.println("Size: " + list.size());

        System.out.println("Item at pos=4: ");
        try{
            System.out.println(list.get(4));
        } catch (NotFound e){
            System.out.println(e.getMessage());
        }

        System.out.println("Searching for item 15...");
        try{
            System.out.println("Items checked: " + list.search(15));
        } catch (SearchNotFound e){
            System.out.println(e.getMessage());
        }
    }

    public static <T extends Comparable<T>> void showList(DoublyLinkedList<T> l){
        for (T elem:l){
            System.out.println(elem);
        }
    }
}

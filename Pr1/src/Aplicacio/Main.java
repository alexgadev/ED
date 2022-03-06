package Aplicacio;


import EstructuraDeDades.DoublyLinkedList;
import Exceptions.NotFound;

import java.util.Iterator;

public class Main {
    @SuppressWarnings("unchecked")
    public static <T> void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.create();
    /*
        Iterator<T> iter = list.iterator();

        list.insert(1, 10);
        list.insert(2, 20);
        list.insert(3, 30);
        list.insert(2, 15);
        list.insert(1, 115);
        list.insert(256);
        System.out.println("List initially:");
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("Size: " + list.size());

        System.out.println("Removing first:");
        list.remove(1);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("Size: " + list.size());

        System.out.println("Item at pos=4: " + list.get(4));


        System.out.println("Searchng for item 115...");
        try{
            System.out.println("Items checked: " + list.search(115));
        } catch (){

        }
        */

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(15);
        list.insert(115);
        list.insert(3,256);
        int n = 0;
        while(n < list.size()){
            try {
                System.out.println(list.get(n));
                n++;
            } catch (NotFound e){
                System.out.println("No es pot trobar l'element");
            }
        }

        try {
            list.remove(list.size() - 1);
        } catch (NotFound e){
            System.out.println("L'element a eliminar no s'ha pogut trobar");
        }

        n = 0;
        while(n < list.size()){
            try {
                System.out.println(list.get(n));
                n++;
            } catch (NotFound e){
                System.out.println("No es pot trobar l'element");
            }
        }


    }

}

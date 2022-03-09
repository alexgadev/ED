package Aplicacio;

import EstructuraDeDades.Part1.DoublyLinkedList;
import EstructuraDeDades.Part2.HashTable;

import java.util.Random;

public class SearchCost {
    public static void main(String[] args){
        final int MAX_SIZE = 50000;
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        //HashTable<Integer, Integer> ht = new HashTable<>(1000);

        Random rand = new Random();

        for (int i = 1000; i <= MAX_SIZE; i+=1000){
            // add i random integers from 1 to i/2 to the lists
            for (int j = 0; j < i; j++){
                dll.insert(rand.nextInt(1, i / 2));
                //ht.insert(i, rand.nextInt(1, i / 2));
            }

            for (int j = 0; j < i; j++){
                //dll.search(rand.nextInt(1, i / 2));
            }
        }
    }
}

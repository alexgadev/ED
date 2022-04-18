package Aplicacio;

import EstructuraDeDades.Part1.DoublyLinkedList;
import EstructuraDeDades.Part2.HashTable;
import Exceptions.*;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Random;

public class SearchCost {
    public static void main(String[] args){
        final int MAX_SIZE = 50000;
        DoublyLinkedList<Integer> dll;
        HashTable<Integer, Integer> ht;

        Random rand = new Random();

        File file1 = new File("resultdll.csv");
        File file2 = new File("resultht.csv");
        try {
            FileWriter fwdll = new FileWriter(file1);
            FileWriter fwht = new FileWriter(file2);

            CSVWriter writerdll = new CSVWriter(fwdll);
            CSVWriter writerht = new CSVWriter(fwht);

            String[] header = {"Size", "Cost","Stdev"};

            writerdll.writeNext(header);
            writerht.writeNext(header);

            for (int i = 1000; i <= MAX_SIZE; i += 1000) {
                double dllsum = 0;
                double htsum = 0;

                // create lists of i elements
                dll = new DoublyLinkedList<>();
                ht = new HashTable<>(i);

                System.out.println("Creating lists of " + i + " size...");

                // add i random integers from 1 to i/2 to the lists
                int j = 0;
                while (j < i) {
                    dll.insert(rand.nextInt(1, i / 2));
                    try {
                        ht.insert(rand.nextInt(1, i / 2), i);
                    } catch (SizeException e) {
                        //System.out.println(e.getMessage());
                    }
                    j++;
                }

                DoublyLinkedList<Integer> dllsearch = new DoublyLinkedList<>();
                DoublyLinkedList<Integer> htsearch = new DoublyLinkedList<>();

                System.out.println("Searching for " + i + " elements...");

                // search for i random integers
                j = 0;
                while (j < i) {

                    // if it's found add it to the total sum for that i size
                    try {
                        int dllres = dll.search(rand.nextInt(1, i / 2));
                        dllsearch.insert(dllres);
                        dllsum += dllres;

                    } catch (SearchNotFound s) { // if it can't be found add the total cost of searching the table
                        dllsum += s.getCost();
                        //System.out.println(s.getMessage());
                    }

                    // if it's found
                    try {
                        int htres = ht.search(rand.nextInt(1, i / 2));
                        htsearch.insert(htres);
                        htsum += htres;
                    } catch (SearchNotFound s) { // if it can't be found
                        htsum += s.getCost();
                        //System.out.println(s.getMessage());
                    }

                    j++;
                }

                System.out.println("Saving results...");

                // saving the results
                double dllmean = dllsum / i;
                double htmean = htsum / i;

                double dllstdev = calculateSD(dllsearch, dllsum);
                double htstdev = calculateSD(htsearch, htsum);

                System.out.println("Doubly Linked List: ");
                System.out.println("Size: " + i + "\tMean: " + dllmean + "\tStandard Deviation: " + dllstdev + "\t");

                System.out.println("Hash Table: ");
                System.out.println("Size: " + i + "\tMean: " + htmean + "\tStandard Deviation: " + htstdev + "\t");

                String[] data1 = {String.valueOf(i), String.valueOf(dllmean), String.valueOf(dllstdev)};
                writerdll.writeNext(data1);

                String[] data2 = {String.valueOf(i), String.valueOf(htmean), String.valueOf(htstdev)};
                writerht.writeNext(data2);
            }
            writerdll.close();
            writerht.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Done!!!");
    }

    public static double calculateSD(DoublyLinkedList<Integer> list, double sum){
        double stdev = 0.0;
        int length = list.size();

        double mean = sum / length;

        for (Integer n : list){
            stdev += Math.pow(n - mean, 2);
        }

        return Math.sqrt(stdev/length);
    }
}

package Aplicacio;

import EstructuraDeDades.Graph;
import EstructuraDeDades.Estacio;
import Exceptions.CannotAddElement;

public class Main {
    //Graph<Estacio, Double> graph = new Graph<>();

    public static void main(String[] args){
        Graph<String, Integer> graph = new Graph<>();

        try {
            graph.addEdge("A", "B", 3);
            graph.addEdge("B", "C", 1);
            graph.addEdge("B", "D", 4);
            graph.addEdge("C", "D", 2);
            graph.addEdge("A", "D", 7);
            graph.addEdge("A", "E", 8);
            graph.addEdge("D", "E", 3);
        } catch (CannotAddElement e) {
            e.printStackTrace();
        }

        graph.printGraph();
    }
}

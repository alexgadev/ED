package Aplicacio;

import EstructuraDeDades.Graph;
import EstructuraDeDades.ICAENGraph;
import Exceptions.CannotAddElement;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args){
            /*String vertex1 = "A";
            String vertex2 = "B";
            String vertex3 = "C";
            String vertex4 = "D";
            String vertex5 = "E";

            List<String> vertices = new ArrayList<>();
            vertices.add(vertex1);
            vertices.add(vertex2);
            vertices.add(vertex3);
            vertices.add(vertex4);
            vertices.add(vertex5);

            Graph<String, Integer> graph = new Graph<>(vertices);

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

            graph.printGraph();*/

            ICAENGraph graph = new ICAENGraph("icaen.json");
            List<String> list = graph.optimalPath("Tortosa - INGETEAM EdRR 1", "Mataró - DBT EdRR 1", 12);

            System.out.println(list.size());
            System.out.println(list);


            //graph.graf.printGraph();
    }
}

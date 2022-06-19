package Aplicacio;

import EstructuraDeDades.Graph;
import EstructuraDeDades.ICAENGraph;
import Exceptions.CannotAddElement;
import Exceptions.UnreachablePath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            }*/

            ICAENGraph graph = new ICAENGraph("icaen.json");
            List<String> list = new ArrayList<>();
            try {
                list = graph.optimalPath("La Pobla de Mafumet - LAFON EdRR 1", "Aeroports de la Generalitat - SELBA EdRSR 2 La Seu", 40);
            }
            catch (UnreachablePath e){
                e.printStackTrace();
            }

            System.out.println(list.size());
            System.out.println(list);



            /*

                Inicialització de les variables


             */

            System.out.println("Main test...");
            int opt;
            do {
                switch (chooseOption()){
                    case 0:
                }


            }while(opt != 0);
    }

    public static int chooseOption(){

        Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();
        showOptions();

    }

    public static void showOptions(){
        System.out.println("Choose an option:");
        System.out.println("\n--- Graph Functionalities ---");
        System.out.println("1. Add an edge");
        System.out.println("2. Check if and edge exists");
        System.out.println("3. Get the value of an edge");
        System.out.println("4. Show all adjacent nodes to a node passed by parameter");
        System.out.println("5. Mostra el graf");
        System.out.println("\n--- ICAEN Functionalities ---");
        System.out.println("6. Mostra el camí optim d'una estació a una altra");
        System.out.println("7. Mostra les zones on la màxima distancia no està garantida");
    }
}

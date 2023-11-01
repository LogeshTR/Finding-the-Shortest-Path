import java.util.LinkedList;
import java.util.PriorityQueue;

class Graph {
    private final int V;
    private final LinkedList<Node>[] adj;

    static class Node {
        int dest;
        int weight;

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest, int weight) {
        Node newNode = new Node(dest, weight);
        adj[src].add(newNode);

        newNode = new Node(src, weight);
        adj[dest].add(newNode);
    }

    void dijkstra(int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        dist[src] = 0;
        minHeap.add(new Node(src, 0));

        while (!minHeap.isEmpty()) {
            Node minHeapNode = minHeap.poll();
            int u = minHeapNode.dest;

            for (Node neighbor : adj[u]) {
                int v = neighbor.dest;
                int weight = neighbor.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    minHeap.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("TouristPlaces  Distance from Resort");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t\t" + dist[i] + "km");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int V = 9;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        int choice;
        while (true) {
            System.out.println("\n\t\t==========================================================================");
            System.out.println("\n\t\t\t        ******Shortest path finder****");
            System.out.println("\n\t\t==========================================================================");
            System.out.println("\n\n\t\tPress '1' to view Roadmap ");
            System.out.println("\n\t\tPress '2' to Show the Shortest Path from Resorts to Tourist places");
            System.out.println("\n\t\tPress '3' to Description of the places");
            System.out.println("\n\t\tPress '4' to exit");
            System.out.print("\n\n\t\tEnter your choice: ");
            choice = Integer.parseInt(System.console().readLine());

            switch (choice) {
                case 1:
                    System.out.println("\n\t\t==========================================================================");
                    System.out.println("\n\t\t\t        ******Shortest path finder****");
                    System.out.println("\n\t\t==========================================================================");
                    System.out.println("\n\nThe RoadMap:\n\n\n\n");
                    System.out.println("\t\t                        (8km)         (7km)                  ");
                    System.out.println("\t\t      Elk Hill Murugan ------ Pine  --------  Sterling       ");
                    System.out.println("\t\t         Temple              Forest            Resort        ");
                    System.out.println("\t\t        /   |                 |    \\              \\        \t\tTop Resorts in OOTY");
                    System.out.println("\t\t       /    |                 |     \\              \\       \t\t********");
                    System.out.println("\t\t (4km)/     |            (2km)|      \\              \\(9km) ");
                    System.out.println("\t\t     /      |                 |       \\              \\     ");
                    System.out.println("\t\t    /       |                 |        \\              \\    ");
                    System.out.println("\t\t   /        |                 |         \\              \\   ");
                    System.out.println("\t\t Avalanche  |(11km)      Western valley  \\ (4km)      Thunder");
                    System.out.println("\t\t   Lake     |          /     Resort       \\            World");
                    System.out.println("\t\t    \\       |         /       |            \\           /   ");
                    System.out.println("\t\t     \\      |   (7km)/   (6km)|             \\         /    ");
                    System.out.println("\t\t (8km)\\     |       /         |              \\       /(10km)");
                    System.out.println("\t\t       \\    |      /          |               \\     /      ");
                    System.out.println("\t\t        \\   |     /           |                \\   /       ");
                    System.out.println("\t\t          Rose    (1km)                (2km)   Green Nest     ");
                    System.out.println("\t\t         Garden ---------- Doodabetta --------  Resort       ");
                    System.out.println("\t\t                              peak                                \n\n\n  ");
                    break;
                case 2:
                    System.out.println("\n\t\t==========================================================================");
                    System.out.println("\n\t\t\t        ******Shortest path finder****");
                    System.out.println("\n\t\t==========================================================================\n\n");
                    System.out.println("\t\t                        (8km)         (7km)                  ");
                    System.out.println("\t\t      Elk Hill Murugan ------ Pine  --------  Sterling       ");
                    System.out.println("\t\t         Temple              Forest            Resort        ");
                    System.out.println("\t\t        /   |                 |    \\              \\        \t\tTop Resorts in OOTY");
                    System.out.println("\t\t       /    |                 |     \\              \\       \t\t********");
                    System.out.println("\t\t (4km)/     |            (2km)|      \\              \\(9km) ");
                    System.out.println("\t\t     /      |                 |       \\              \\     ");
                    System.out.println("\t\t    /       |                 |        \\              \\    ");
                    System.out.println("\t\t   /        |                 |         \\              \\   ");
                    System.out.println("\t\t Avalanche  |(11km)      Western valley  \\ (4km)      Thunder");
                    System.out.println("\t\t   Lake     |          /     Resort       \\            World");
                    System.out.println("\t\t    \\       |         /       |            \\           /   ");
                    System.out.println("\t\t     \\      |   (7km)/   (6km)|             \\         /    ");
                    System.out.println("\t\t (8km)\\     |       /         |              \\       /(10km)");
                    System.out.println("\t\t       \\    |      /          |               \\     /      ");
                    System.out.println("\t\t        \\   |     /           |                \\   /       ");
                    System.out.println("\t\t          Rose    (1km)                (2km)   Green Nest     ");
                    System.out.println("\t\t         Garden ---------- Doodabetta --------  Resort       ");
                    System.out.println("\t\t                              peak                                \n\n\n  ");
                    int x;
                    System.out.print("Enter your choice : ");
                    x = Integer.parseInt(System.console().readLine());

                    System.out.println();
                    switch (x) {
                        case 1:
                            graph.dijkstra(3);
                            System.out.println("------------------------------------------------");
                            System.out.println("|0---------------> Avalanche lake               |");
                            System.out.println("|1 --------------> Elk hill murugan Temple      |");
                            System.out.println("|2---------------> pine forest                  |");
                            System.out.println("|3---------------> sterling hotel               |");
                            System.out.println("|4---------------> Thunder world                |");
                            System.out.println("|5---------------> Green Nest resort            |");
                            System.out.println("|6---------------> Doddabetta peak              |");
                            System.out.println("|7---------------> Rose gardern                 |");
                            System.out.println("|8---------------> Western valley resort        |");
                            System.out.println("------------------------------------------------");
                            System.out.println("Sterling Ooty Resort :");
                            System.out.println("Contact: +91 9003302727");
                            System.out.println("Mail us: crs@sterlingholidays.com");
                            break;
                        case 2:
                            graph.dijkstra(5);
                            System.out.println("------------------------------------------------");
                            System.out.println("|0---------------> Avalanche lake               |");
                            System.out.println("|1 --------------> Elk hill murugan Temple      |");
                            System.out.println("|2---------------> pine forest                  |");
                            System.out.println("|3---------------> sterling hotel               |");
                            System.out.println("|4---------------> Thunder world                |");
                            System.out.println("|5---------------> Green Nest resort            |");
                            System.out.println("|6---------------> Doddabetta peak              |");
                            System.out.println("|7---------------> Rose gardern                 |");
                            System.out.println("|8---------------> Western valley resort        |");
                            System.out.println("------------------------------------------------");
                            System.out.println("Green Nest Resort :");
                            System.out.println("Contact: +91 9600445111");
                            System.out.println("Mail us: reservations@greennest.in");
                            break;
                        case 3:
                            graph.dijkstra(8);
                            System.out.println("------------------------------------------------");
                            System.out.println("|0---------------> Avalanche lake               |");
                            System.out.println("|1 --------------> Elk hill murugan Temple      |");
                            System.out.println("|2---------------> pine forest                  |");
                            System.out.println("|3---------------> sterling hotel               |");
                            System.out.println("|4---------------> Thunder world                |");
                            System.out.println("|5---------------> Green Nest resort            |");
                            System.out.println("|6---------------> Doddabetta peak              |");
                            System.out.println("|7---------------> Rose gardern                 |");
                            System.out.println("|8---------------> Western valley resort        |");
                            System.out.println("------------------------------------------------");
                            System.out.println("Western Valley Resort :");
                            System.out.println("Contact: +91 90039 30530");
                            System.out.println("Mail us: westernvalleyresorts@gmail.com");
                            break;
                    }
                    break;
                case 3:
                    if (choice == 3) {
                        System.out.println("\n\t\t==========================================================================");
                        System.out.println("\n\t\t\t        ******TOURISM****");
                        System.out.println("\n\t\t==========================================================================\n\n");
                        System.out.println("\t\t------------------------------------------------");
                        System.out.println("|0---------------> Avalanche lake               |");
                        System.out.println("|1 --------------> Elk hill murugan Temple      |");
                        System.out.println("|2---------------> pine forest                  |");
                        System.out.println("|3---------------> sterling hotel               |");
                        System.out.println("|4---------------> Thunder world                |");
                        System.out.println("|5---------------> Green Nest resort            |");
                        System.out.println("|6---------------> Doddabetta peak              |");
                        System.out.println("|7---------------> Rose gardern                 |");
                        System.out.println("|8---------------> Western valley resort        |");
                        System.out.println("\t\t------------------------------------------------");
                        System.out.print("\nEnter the Description choices : ");
                        int choices;
                        String[] arr = {
                            "Avalanche_lake.txt", "Elk hill murugan Temple.txt", "pine forest .txt", "sterling hotel.txt",
                            "Thunder world.txt", "Green Nest resort.txt", "Doddabetta peak.txt", "Rose garden.txt",
                            "Western valley resort.txt"
                        };
                        choices = Integer.parseInt(System.console().readLine());
                        System.out.println(arr[hashcode(choices)]);
                        readfile(arr[hashcode(choices)]);
                        System.out.println();
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    static void readfile(String filename) {
        try {
            java.io.FileReader fileReader = new java.io.FileReader(filename);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (java.io.IOException e) {
            System.out.println("File is not found");
        }
    }

    static int hashcode(int n) {
        return n % 10;
    }
}
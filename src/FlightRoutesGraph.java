import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;

import java.util.HashSet;

public class FlightRoutesGraph {



    private class Edge {
        private String node1;
        private String node2;

        public Edge(String from, String to) {
            node1 = from;
            node2 = to;
        }
    }

    private MathSet<String> nodes;          

    private MathSet<Edge> edges;            

    public FlightRoutesGraph() {
        nodes = new BSTSet<>();
        edges = new HashSet<>();            
    }

    public void addNode(String city) {
        nodes.add(city);
    }

    public void addEdge(String city1, String city2) {
        Edge connection = new Edge(city1, city2);
        edges.add(connection);
    }



    /**
     *
     * @param city
     */
    public MathSet<String> getNeighbors(String city) {
        MathSet<String> neighbors = new BSTSet<>();

        for (Edge e: edges.keys()) {
            if (e.node1.equals(city)) {
                neighbors.add(e.node2);
            }
            else if (e.node2.equals(city)) {
                neighbors.add(e.node1);
            }
        }

        return neighbors;
    }

    public static void main(String[] args) {
        FlightRoutesGraph g = new FlightRoutesGraph();
        g.addNode("JFK");
        g.addNode("ORD");
        g.addNode("ATL");
        g.addNode("MCO");
        g.addNode("DEN");
        g.addEdge("ATL", "MCO");
        g.addEdge("JFK", "MCO");
        g.addEdge("DEN", "ORD");
        g.addEdge("ORD", "ATL");
        MathSet<String> directFromJFK = g.getNeighbors("JFK");
        MathSet<String> directFromATL = g.getNeighbors("ATL");

    }
}

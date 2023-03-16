import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.HashSet;
import edu.greenriver.sdev333.MathSet;

public class FlightRoutesGraph {
    // two sets needed to model a graph (network)
    // 1. a set of vertices (points,nodes) - airports
    // 2. a set of edges (connections, lines, relationship) - route between airports

    /**
     * private helper class for within MathSet<Edge>
     */
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
        nodes = new BSTSet<>(); // BST ok here b/c strings are comparable
        edges = new HashSet<>(); // must use HashSet here b/c edges are not comparable
    }

    public void addNode(String city) {

    }

    public void addEdge(String city1, String city2) {
        Edge connection = new Edge(city1,city2);
        edges.add(connection);
    }

    MathSet<String> getNeighbors (String city) {
        // create an empty set to hold the results
        MathSet<String> neigbors = new BSTSet<>();

        // loop through the edges and check
        // if the city is either in node1 or node2
        for (Edge e : edges.keys()) {
            if(e.node1.equals(city)) {
                neigbors.add(e.node2);
            } else if (e.node2.equals(city)) {
                neigbors.add(e.node1);
            }
        }

        return neigbors;
    }

    public static void main(String[] args) {
        FlightRoutesGraph graph = new FlightRoutesGraph();

        // add all teh cites first (nodes)
        graph.addNode("JFK");
        graph.addNode("ORD");
        graph.addNode("ATL");
        graph.addNode("MCO");
        graph.addNode("DEN");

        // add connections between cities (edges, route)
        graph.addEdge("JFK","MCO");
        graph.addEdge("ALT","MCO");
        graph.addEdge("DEN","ORD");
        graph.addEdge("JFK","MCO");
        graph.addEdge("JFK","MCO");

        // loo for direct flights from JFK
        MathSet<String> directJFK = graph.getNeighbors("JFK");
        MathSet<String> directFromATL = graph.getNeighbors("ATL");

    }
}

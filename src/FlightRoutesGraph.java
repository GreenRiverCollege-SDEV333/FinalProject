import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.HashSet;
import edu.greenriver.sdev333.MathSet;

public class FlightRoutesGraph {
    // two sets needed to model a graph (network)
    // 1. a set of vertices (points, nodes) - airports
    // 2. a set of edges (connections, lines, relationships) - route between airport

    // helper class
    private class Edge {
        private String node1;
        private String node2;

        public Edge(String from, String to) {
            node1 = from;
            node2 = to;
        }
    }
    // fields
    private MathSet<String> nodes;
    private MathSet<Edge> edges;

    public FlightRoutesGraph()
    {
        nodes = new BSTSet<>(); // BST ok here b/c strings are comparable
        edges = new HashSet<>(); // must use HashSet here b/c edges aren't comparable
    }

    public void addNode(String city) {
        nodes.add(city);
    }

    public void addEdge(String city1, String city2) {
        Edge connection = new Edge(city1, city2);
        edges.add(connection);
    }

    MathSet<String> getNeighbors(String city) {
        // create an empty set to gold the results
        MathSet<String> neighbors = new BSTSet<>();

        // loop through the edges and check
        // if the city is either in node 1 or node 2
        for (Edge e : edges.keys()) {
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

        // add all the cities first (nodes) - order doesn't matter with sets
        g.addNode("JFK");
        g.addNode("ORD");
        g.addNode("ATL");
        g.addNode("MCO");
        g.addNode("DEN");

        // add connections between cities (edges, routes)
        g.addEdge("JFK", "MCO");
        g.addEdge("ATL", "MCO");
        g.addEdge("DEN", "ORD");
        g.addEdge("ORD", "ATL");
        // more to go if you want...

        // look for direct flights from JFK
        MathSet<String> directFromJFK = g.getNeighbors("JFK");
        MathSet<String> directFromAtl = g.getNeighbors("ATL");

    }

}

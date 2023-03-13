import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;

import java.util.HashSet;

/**
 * Created in class 3/13/23, Ken coding
 *
 * Importing interface MathSet - can we use this for testing?
 */
public class FlightRoutesGraph {

    // two sets needed to model the graph
    // 1. a set of vertices (points, nodes) - airports
    // 2. a set of edges (connections, lines, relationships) - routes between airports

    private class Edge {
        private String node1;
        private String node2;

        public Edge(String from, String to) {
            node1 = from;
            node2 = to;
        }
    }

    private MathSet<String> nodes;          // set of nodes

    private MathSet<Edge> edges;            // set of edges

    public FlightRoutesGraph() {
        nodes = new BSTSet<>();
        edges = new HashSet<>();            // must use HashSet here as edges are not comparable
    }

    public void addNode(String city) {
        nodes.add(city);
    }

    public void addEdge(String city1, String city2) {
        Edge connection = new Edge(city1, city2);
        edges.add(connection);
    }

    /*
    Edge Set = {
       ORD, JFK
       JFK, MCO
       DEN, PHX
       LAS, DEN
       DFW, ORD
       ATL, JFK
    }

    IF we are looking for cities connected to Denver, we are looking for 'Adjacency, i.e. neighbors.
     */

    /**
     * Return cities that are neigbors to given city.  There can be more than
     * one neighbor, so should return a Set, i.e. MathSet of Strings/neighbors
     *
     * @param city
     */
    public MathSet<String> getNeighbors(String city) {
        // create an empty  set to hold the results
        MathSet<String> neighbors = new BSTSet<>();

        // loop through edges and check if city is
        // in either node1 or node2
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

        // add all the cities first (nodes)
        g.addNode("JFK");
        g.addNode("ORD");
        g.addNode("ATL");
        g.addNode("MCO");
        g.addNode("DEN");

        // add connections beween cities
        g.addEdge("ATL", "MCO");
        g.addEdge("JFK", "MCO");
        g.addEdge("DEN", "ORD");
        g.addEdge("ORD", "ATL");
        // more to go if you want

        // look for direct flights from JFK
        MathSet<String> directFromJFK = g.getNeighbors("JFK");
        MathSet<String> directFromATL = g.getNeighbors("ATL");

    }
}

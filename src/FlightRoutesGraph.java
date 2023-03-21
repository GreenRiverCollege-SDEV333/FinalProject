import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.HashSet;
import edu.greenriver.sdev333.MathSet;

public class FlightRoutesGraph {
    //have to have two sets to model a graph (network)
    // 1. a set of vertices (aka points or nodes) - in this case its our airports
    // 2. a set of edges (aka connections, lines, relationships) - in this case its routes between airports

    //helper class for our edges/connections
    //a string from node1 to node2
    private class Edge {
        private String node1;
        private String node2;

        //helper constructor to build an edge
        //a connection from one node to another node
        //take in from and save it into node1
        //take in to and save it into node2
        public Edge(String from, String to) {
            node1 = from;
            node2 = to;
        }
    }

    //our sets
    private MathSet<String> nodes; //our nodes are string data types ex: JFK
    private MathSet<Edge> edges; // our edges are connections between two nodes

    //constructor for FlightRoutesGraph
    public FlightRoutesGraph() {
        nodes = new BSTSet<>(); //we can use BSTSet because our nodes are comparable
        edges = new HashSet<>(); // our edges cannot be compared so we must put it in a HashSet
    }

    /**
     * adding a city to the graph
     * @param city
     */
    public void addNode(String city) {
        // when we get the city we put it into the nodes set
        nodes.add(city);
    }

    /**
     * adding a connection between 2 cities
     * @param city1
     * @param city2
     */
    public void addEdge(String city1, String city2) {
        //add the cities to the edge set
        Edge connection = new Edge(city1, city2);
        edges.add(connection);
    }

    // if someone gives me a city, we want to know its neighbors
    // therefor the return type should be a set of strings
    MathSet<String> getNeighbors(String city) {
        // create an empty set to hold the results
        MathSet<String> neighbors = new BSTSet<>();

        //need to walk through the edges so we need to write a loop
        // and check if the city is in either node1 or node2
        for(Edge e : edges.keys()) {
            if (e.node1.equals(city)) {
                neighbors.add(e.node2);
            }
            else if (e.node2.equals(city)) {
                neighbors.add(e.node1);
            }
        }

        return neighbors;

    }



    //testing
    public static void main(String[] args) {
        FlightRoutesGraph g = new FlightRoutesGraph();

        // add all the cities first
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

        //look for direct flights from JFK
        MathSet<String> directJFK = g.getNeighbors("JFK");
        MathSet<String> directATL = g.getNeighbors("ATL");


    }

}

import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.HashingSet;
import edu.greenriver.sdev333.MathSet;

public class FlightRoutesGraph {
    //two sets needed to model graph/network
    //1. set of vertices (points, nodes, etc) -airports
    //2. set of edges (where the points connect with each other) -routes

    private class Edge{
        private String city1;
        private String city2;

        public Edge(String one, String two){
            this.city1 = one;
            this.city2 = two;
        }
    }

    private MathSet<String> nodes;
    private MathSet<Edge> connections;

    public FlightRoutesGraph(){
        nodes = new BSTSet<>();
        connections = new HashingSet<>();
    }

    public void addNode(String city){
        nodes.add(city);
    }
    public void addEdge(String city1, String city2){
        connections.add(new Edge(city1, city2));
    }
    public MathSet<String> getNeighbors(String city){
        //empty set to hold results
        MathSet<String> neighbors = new BSTSet<>();
        //loop through edges looking for node value
        for (Edge e: connections.keys()) {
            if(e.city1.equals(city)){
                neighbors.add(e.city2);
            } else if (e.city2.equals(city)) {
                neighbors.add(e.city1);
            }
        }
        return neighbors;
    }


    public static void main(String[] args) {
        FlightRoutesGraph g = new FlightRoutesGraph();
        //add cities
//        g.addNode("SEA");
        g.addNode("JFK");
        g.addNode("ORD");
        g.addNode("ATL");
        g.addNode("MCO");
        g.addNode("DEN");

        //add connections
        g.addEdge("JFK", "MCO");
        g.addEdge("ATL", "MCO");
        g.addEdge("DEN", "ORD");
        g.addEdge("ORD", "ATL");
//        g.addEdge("JFK", "MCO");
//        g.addEdge("JFK", "MCO");
//        g.addEdge("JFK", "MCO");

        //look for direct flights from JFK
        MathSet<String> directJFK = g.getNeighbors("JFK");
    }
}

package edu.greenriver.sdev333;

/**
 * This class represents a basic graph of airports connected
 * by flight paths.
 * It is an introductory class which only contains a way to build
 * the graph and find the nodes directly connected. We will be
 * going into greater depth (or breadth, lol) on this concept next quarter
 */
public class FlightRoutesGraph {
    //two sets need to model a graph (network)
    //1. a set of vertices (points, nodes) --airports
    //2. a set of edges (connections, lines, routes, relationships)--route between airports

    //helper class
    private class Edge{
        private String node1;
        private String node2;

        public Edge(String from, String to){
            node1 = from;
            node2 = to;
        }
    }
    //airports
    private MathSet<String> nodes;
    //fight paths
    private MathSet<Edge> edges;

    /**
     * default constructor
     */
    public FlightRoutesGraph(){
        nodes = new BSTset<>(); //BST okay because strings are comparable
        edges = (MathSet<Edge>) new HashSet();//must use hash here because edges are not comparable
    }

    /**
     * add a node
     * @param city airport node
     */
    public void addNode(String city){
        nodes.add(city);
    }

    /**
     * add a route from one city to another
     * @param city1 one of the connecting cities
     * @param city2 the other connecting city
     */
    public void addEdge(String city1, String city2){
        Edge connection = new Edge(city1, city2);
        edges.add(connection);
    }

    /**
     * find all cities that are connected to given city via an edge (flight path)
     * @param city airport to check
     * @return airports directly connected to airport to check
     */
    public MathSet<String> getNeighbors(String city){
        //create an empty set to hold the results
        MathSet<String> neighbors = new BSTset<>();
        //loop through edges and check
        //is city either in node1 or node2?
        for(Edge e : edges.keys()){
            if (e.node1.equals(city)) {
                neighbors.add(e.node2);
            } else if (e.node2.equals(city)) {
                neighbors.add((e.node1));
            }
        }
        return neighbors;
    }

    //explore graph with BFS--breadth first search
    //or with DFS--depth first search (use recursion or stack)
    //shortest path algorithm

    /**
     * Tester method (to keep Main class clean for testing BSTSet and HashSet only)
     * @param args
     */
    public static void main(String[] args){
        FlightRoutesGraph g = new FlightRoutesGraph();

        //add all cities first
        g.addNode("JFK");
        g.addNode("ORD");
        g.addNode("ATL");
        g.addNode("MCO");
        g.addNode("SEA");
        g.addNode("DEN");

        //add connections between cities
        g.addEdge("JFK","MCO");
        g.addEdge("ATL","MCO");
        g.addEdge("DEN","ORD");
        g.addEdge("ORD","ATL");
        g.addEdge("SEA","DEN");

        //look for direct flights from MCO
        MathSet<String> directFromMCO = g.getNeighbors("MCO");
        MathSet<String> directFromATL = g.getNeighbors(("ATL"));
        System.out.println("Direct flights from MCO: " + directFromMCO);
        System.out.println("Direct flights from ATL: " + directFromATL);
    }
}
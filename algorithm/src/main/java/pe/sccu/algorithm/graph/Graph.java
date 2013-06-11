package pe.sccu.algorithm.graph;


public class Graph {

    private final boolean directed;

    private static final double DEFAULT_WEIGHT = 1.0;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(int u, int v) {
        addEdge(u, v, DEFAULT_WEIGHT);
    }

    public void addEdge(int u, int v, double weight) {

    }

    public double getEdgeWeight(int u, int v) {
        return 0;
    }

    public boolean hasEdge(int u, int v) {
        return false;
    }

    public boolean isDirected() {
        return directed;
    }

    public long numVertices() {
        return 0;
    }

    public boolean removeEdge(int u, int v) {
        return false;
    }
}

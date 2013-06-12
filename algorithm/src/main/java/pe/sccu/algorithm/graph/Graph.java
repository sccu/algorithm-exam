package pe.sccu.algorithm.graph;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SetMultimap;

public class Graph {

    private final boolean directed;

    private SetMultimap<Integer, Edge> edges = HashMultimap.<Integer, Edge> create();

    private static final double DEFAULT_WEIGHT = 1.0;

    public static Graph createDirectedGraph() {
        return new Graph(true);
    }

    public static Graph createIndirectedGraph() {
        return new Graph(false);
    }

    private Graph(boolean directed) {
        this.directed = directed;
    }

    public void addEdge(int u, int v) {
        addEdge(u, v, DEFAULT_WEIGHT);
    }

    public void addEdge(int u, int v, double weight) {
        Edge edge = new Edge(u, v, weight);
        edges.remove(u, edge);
        edges.put(u, edge);
    }

    public List<Edge> getEdges(int u) {
        return ImmutableList.copyOf(edges.get(u));
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

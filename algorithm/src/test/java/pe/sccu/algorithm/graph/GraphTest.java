package pe.sccu.algorithm.graph;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testAddEdge() {
        Graph g = Graph.createIndirectedGraph();
        g.addEdge(0, 1);
        g.addEdge(0, 1, 2.0);
        List<Edge> edges = g.getEdges(0);
        assertEquals(1, edges.size());
        assertEquals(2.0, edges.get(0).getWeight(), Double.MIN_VALUE);
    }

}

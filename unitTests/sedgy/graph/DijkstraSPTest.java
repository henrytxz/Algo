package sedgy.graph;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.junit.Test;

public class DijkstraSPTest {

    @Test
    public void testHasPathTo() throws Exception {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(5);
        G.addEdge(new DirectedEdge(0, 1, 5.0));
        G.addEdge(new DirectedEdge(0, 2, 2.0));
//        G.addEdge(new DirectedEdge(0, 2, 8.0));
//        G.addEdge(new DirectedEdge(0, 3, 10.0));
//        G.addEdge(new DirectedEdge(1, 2, 1.0));
//        G.addEdge(new DirectedEdge(1, 4, 6.0));
//        G.addEdge(new DirectedEdge(2, 4, 3.0));
//        G.addEdge(new DirectedEdge(3, 4, 7.0));
        DijkstraSP shortestPath = new DijkstraSP(G, 0);
        System.out.println(shortestPath.hasPathTo(4));
    }
}
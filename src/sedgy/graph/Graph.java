package sedgy.graph;

import edu.princeton.cs.introcs.StdOut;
import utility.In;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by henry on 8/31/2014.
 */
public class Graph {
    private int V;
    private int E;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        //adj = new ArrayList<Integer>[V];  Java doesn't allow generic array creation
        adj = (List<Integer>[]) new LinkedList[V];  //unchecked cast warning
        for (int v=0; v<V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E<0) throw new IllegalArgumentException("negative number of edges!");
        for (int i=0; i<E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        if (v<0 || v>V) throw new IndexOutOfBoundsException();  //thanks to Robert Sedgewick, Kevin Wayne for this reminder
        if (w<0 || w>V) throw new IndexOutOfBoundsException();
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() { return V; }
    public int E() { return E; }

    /*
     *  borrowed from Robert Sedgewick, Kevin Wayne
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    /*
     *  borrowed from Robert Sedgewick, Kevin Wayne
     */
    public static void main(String[] args) throws FileNotFoundException {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}

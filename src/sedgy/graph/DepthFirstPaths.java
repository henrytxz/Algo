package sedgy.graph;


import java.util.*;

/**
 * Created by henry on 8/31/2014.
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph g,  int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];

        this.s = s;
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int w) {
        if (!hasPathTo(w)) return null;
        Stack<Integer> reversePath = new Stack<Integer>();
        for (int curr=w; curr!=s; curr=edgeTo[curr]) {
            reversePath.push(curr);
        }
        reversePath.push(s);

        List<Integer> path = new LinkedList<Integer>();
        while (!reversePath.isEmpty()) {
            path.add(reversePath.pop());
        }

        return path;
    }
}

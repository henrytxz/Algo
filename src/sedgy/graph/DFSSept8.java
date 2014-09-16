package sedgy.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by henry on 9/8/2014.
 */
public class DFSSept8 {

    boolean[] marked;
    int[] edgeTo;
    int s;

    /*
        DFS
        starting from vertex s
        dfs on each of its unmarked neighbors
     */
    public DFSSept8(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;

        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        //todo: check v is legal. in bound?
        marked[v] = true;                   // this needs to be here, rather than after checking if a node is visited
        for (int w : G.adj(v)) {
            if (!marked[w]) {               // if we put "marked[v] = true;" here, we may go from 1 to 2, mark 2 then back to 1, mark 1 and never visit a neighbor of 2 called 3
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public List<Integer> pathTo(int v) {
        List<Integer> path = new LinkedList<Integer>();
        if (!hasPathTo(v)) return path;
        Stack<Integer> pathBackwards = new Stack<Integer>();
        pathBackwards.push(v);
        int currentV = v;
        while (currentV!=s) {
            pathBackwards.push(edgeTo[currentV]);
            currentV = edgeTo[currentV];
        }
        while (!pathBackwards.empty()) {
            path.add(pathBackwards.pop());
        }
        return path;
    }
}

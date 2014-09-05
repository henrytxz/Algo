package sedgy.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by henry on 9/5/2014.
 */
public class DepthFirstPathsIterative {
    private int startingPoint;
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> st;

    public DepthFirstPathsIterative(Graph G, int s) {
        startingPoint = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        st = new Stack<Integer>();

        int v = s;
        marked[v] = true;
        st.push(v);

        do {
            v = st.pop();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    st.push(v); //push onto the stack before we move from v to w
                    st.push(w); break; //break out of the loop so can use the stack to do a     v = w
                }
            }
        } while (!st.isEmpty());
    }

    public boolean hasPathTo(int w) {
        if (w<0 || w>marked.length-1) throw new IndexOutOfBoundsException("vertex id needs to be between 0 and total number of vertices-1");
        return marked[w];
    }

    Iterable<Integer> pathTo(int w) {
        if (!hasPathTo(w)) return null;
        Stack<Integer> s = new Stack<Integer>();
        s.push(w);
        while (true) {
            s.push(edgeTo[w]);
            w = edgeTo[w];
            if (w==startingPoint) break;
        }
        List<Integer> path = new ArrayList<Integer>(s.capacity());
        while (!s.isEmpty()) {
            path.add(s.pop());
        }
        return path;
    }
}

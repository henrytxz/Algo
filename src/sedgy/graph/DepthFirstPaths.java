package sedgy.graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by henry on 8/31/2014.
 */
public class DepthFirstPaths {
//    private boolean[] marked;
//    private int[] edgeTo;

    private Map<String, Boolean> marked = new HashMap<String, Boolean>();
    private Map<String, String> edgeTo = new HashMap<String, String>();
    private SG sg;

    public DepthFirstPaths(SG sg,  String s) {
        this.sg = sg;
        dfs(sg, s);
    }

    private void dfs(SG sg, String v) {
        marked.put(v, true);
        for (int w : sg.G().adj(sg.index(v))) {
            if (marked.get(sg.name(w))==null) {
                dfs(sg, sg.name(w));
                edgeTo.put(sg.name(w), v);
            }
        }
    }

    public boolean hasPathTo(String v) {
        Boolean result = marked.get(v);
        return result != null && result == true;
    }

    public Iterable<String> pathTo(String v) {
        Iterable<Integer> path = sg.G().adj(sg.index(v));
        List<String> result = new LinkedList<String>();
        for (Integer i : path) {
            result.add(sg.name(i));
        }
        return result;
    }
}

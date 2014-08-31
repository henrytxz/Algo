package sedgy.graph;

import utility.In;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by henry on 8/31/2014.
 * SG is short for SymbolGraph
 */
public class SG {
    private Map<String, Integer> st;    //todo let's make this a generic class
    private String[] names;
    private Graph G;

    public SG(String fileName, String delimiter) throws FileNotFoundException {
        In in = new In(fileName);
        Set<String> vertices = new HashSet<String>();
        st = new HashMap<String, Integer>();

        while (!in.isEmpty()) {
            String[] v = in.readLine().split(delimiter);
            for (int i=0; i<v.length; i++)
            {
                if (!vertices.contains(v[i])) {
                    vertices.add(v[i]);
                    st.put(v[i], st.size());
                }
            }
        }

        names = new String[vertices.size()];
        for (Map.Entry<String, Integer> entry : st.entrySet()) {
            names[entry.getValue()] = entry.getKey();
        }

        G = new Graph(vertices.size());

        in = new In(fileName);
        while (!in.isEmpty()) {
            String[] v = in.readLine().split(delimiter);
            if (v.length>1)    //todo
            {
                for (int i=1; i<v.length; i++) {
                    G.addEdge(st.get(v[0]), st.get(v[i]));
                }
            }
        }
    }

    public Graph G() {
        return G;
    }

    public int index(String name) {
        return st.get(name);
    }

    public String name(int v) {
        if (v<0 || v>names.length) throw new IndexOutOfBoundsException();
        return names[v];
    }

    public static void main(String[] args)
    {
        String filename = args[0];
        String delim = args[1];
        String v = args[2];
        try {
            SG sg = new SG(filename, delim);
            Graph G = sg.G();

            for (int w : G.adj(sg.index(v)))
                System.out.println(" " + sg.name(w));

        } catch (FileNotFoundException e) {
            System.out.println("file:"+filename+" not found, please check.");
        }
//        while (StdIn.hasNextLine())
//        {
//            String source = StdIn.readLine();
//            for (int w : G.adj(sg.index(source)))
//                StdOut.println(" " + sg.name(w));
//        }
    }
}

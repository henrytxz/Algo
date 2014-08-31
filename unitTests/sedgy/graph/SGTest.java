package sedgy.graph;

import junit.framework.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SGTest {

    @Test
    public void test() throws FileNotFoundException {
        String fileName = "resources/routes";
        String delimiter = " ";
        String v = "ATL";

        SG sg = new SG(fileName, delimiter);
        Graph G = sg.G();
        List<String> neighbors = new ArrayList<String>();
        for (int w : G.adj(sg.index(v))) {
            neighbors.add(sg.name(w));
        }

        Assert.assertTrue(neighbors.contains("JFK"));
        Assert.assertTrue(neighbors.contains("HOU"));
        Assert.assertTrue(neighbors.contains("ORD"));
        Assert.assertTrue(neighbors.contains("MCO"));
    }

}
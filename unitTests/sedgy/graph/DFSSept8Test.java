package sedgy.graph;

import org.junit.Assert;
import org.junit.Test;
import utility.In;

import java.io.FileNotFoundException;

/**
 * Created by henry on 9/8/2014.
 */
public class DFSSept8Test {
    @Test
    public void testPathTo() throws FileNotFoundException {
        Graph graphSept5 = new Graph(new In("resources/graphSept5"));
        DFSSept8 gPath = new DFSSept8(graphSept5, 0);
        Iterable<Integer> path = gPath.pathTo(3);
        StringBuilder sb = new StringBuilder();
        for (Integer i : path) {
            sb.append(i);
            sb.append(" ");
        }
        Assert.assertEquals("0 1 3", sb.toString().trim());
    }
}

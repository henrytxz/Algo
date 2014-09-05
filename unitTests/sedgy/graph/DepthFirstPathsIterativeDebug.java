package sedgy.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utility.In;

import java.io.FileNotFoundException;

public class DepthFirstPathsIterativeDebug {

    DepthFirstPathsIterative gPath;

    @Before
    public void setup() throws FileNotFoundException {
        Graph graphSept5 = new Graph(new In("resources/graphSept5"));
        gPath = new DepthFirstPathsIterative(graphSept5, 0);
    }

    @Test
    public void testHasPathTo() {
        Assert.assertTrue(gPath.hasPathTo(3));
    }

    @Test
    public void testPathTo() {
        Iterable<Integer> path = gPath.pathTo(3);
        StringBuilder sb = new StringBuilder();
        for (Integer i : path) {
            sb.append(i);
            sb.append(" ");
        }
        Assert.assertEquals("0 1 3", sb.toString().trim());
    }
}
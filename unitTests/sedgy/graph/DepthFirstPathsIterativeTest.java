package sedgy.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DepthFirstPathsIterativeTest {

    DepthFirstPathsIterative sgPath;
    SG sg;

    @Before
    public void setup() throws FileNotFoundException {
        String fileName = "resources/routesTestDFS";
        String delimiter = " ";
        String s = "NYC";

        sg = new SG(fileName, delimiter);

        sgPath = new DepthFirstPathsIterative(sg.G(), sg.index(s));
    }

    @Test
    public void testHasPathTo() {
        Assert.assertTrue(sgPath.hasPathTo(sg.index("London")));
    }

    @Test
    public void testPathTo() {
        Iterable<Integer> path = sgPath.pathTo(sg.index("London"));
        StringBuilder sb = new StringBuilder();
        for (Integer i : path) {
            sb.append(sg.name(i));
            sb.append(" ");
        }
        Assert.assertEquals("NYC Barcelona Paris London", sb.toString().trim());
    }
}
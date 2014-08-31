package sedgy.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DepthFirstPathsTest {

    DepthFirstPaths depthFirstPaths;

    @Before
    public void setup() throws FileNotFoundException {
        String fileName = "resources/routesTestDFS";
        String delimiter = " ";
        String s = "NYC";

        SG sg = new SG(fileName, delimiter);

        depthFirstPaths = new DepthFirstPaths(sg, s);
    }

    @Test
    public void testHasPathTo() {
        Assert.assertTrue(depthFirstPaths.hasPathTo("London"));
    }

    @Test
    public void testPathTo() {
        System.out.println(depthFirstPaths.pathTo("London"));
    }
}
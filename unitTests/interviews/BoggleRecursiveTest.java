package interviews;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BoggleRecursiveTest {

    List<BoggleRecursive.CharPositions> charPositionsList = new LinkedList<BoggleRecursive.CharPositions>();

    @Test
    public void testMatchWord1() throws Exception {
        char[][] grid = {{'t','x','x','x'},{'x','a','x','x'},{'x','t','x','x'},{'x','a','r','t'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertTrue(BoggleRecursive.matchWord("tar", grid, charPositionsList));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testMatchWord1, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testMatchWord2() throws Exception {
        char[][] grid = {{'t','x','x','x'},{'x','r','e','e'},{'x','x','x','x'},{'x','a','r','t'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertTrue(BoggleRecursive.matchWord("tree", grid, charPositionsList));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testMatchWord2, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testNoMatchWord1() throws Exception {
        char[][] grid = {{'t','x','x','x'},{'o','r','e','e'},{'x','x','x','x'},{'x','a','r','t'}};
        Assert.assertFalse(BoggleRecursive.matchWord("try", grid, charPositionsList));
        final long startTime = System.currentTimeMillis();
        Assert.assertFalse(BoggleRecursive.matchWord("toe", grid, charPositionsList));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testNoMatchWord1, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testNoMatchWord2() throws Exception {
        char[][] grid = {{'e','y','x','x'},{'x','x','x','x'},{'x','x','x','x'},{'x','x','x','x'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertFalse(BoggleRecursive.matchWord("eye", grid, charPositionsList));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testNoMatchWord2, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testNoMatchWord3() throws Exception {
        char[][] grid = {{'a','c','x','x'},{'x','b','x','x'},{'x','x','x','x'},{'x','x','x','x'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertFalse(BoggleRecursive.matchWord("abca", grid, charPositionsList));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testNoMatchWord3, total execution time: " + (endTime - startTime) );
    }
}
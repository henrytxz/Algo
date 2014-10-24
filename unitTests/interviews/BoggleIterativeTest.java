package interviews;

import org.junit.Assert;
import org.junit.Test;

public class BoggleIterativeTest {

    @Test
    public void testMatchWord1() throws Exception {
        char[][] grid = {{'t','x','x','x'},{'x','a','x','x'},{'x','t','x','x'},{'x','a','r','t'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertTrue(BoggleIterative.matchWord("tar", grid));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testMatchWord1, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testMatchWord2() throws Exception {
        char[][] grid = {{'t','x','x','x'},{'x','r','e','e'},{'x','x','x','x'},{'x','a','r','t'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertTrue(BoggleIterative.matchWord("tree", grid));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testMatchWord2, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testNoMatchWord1() throws Exception {
        char[][] grid = {{'t','x','x','x'},{'o','r','e','e'},{'x','x','x','x'},{'x','a','r','t'}};
        Assert.assertFalse(BoggleIterative.matchWord("try", grid));
        final long startTime = System.currentTimeMillis();
        Assert.assertFalse(BoggleIterative.matchWord("toe", grid));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testNoMatchWord1, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testNoMatchWord2() throws Exception {
        char[][] grid = {{'e','y','x','x'},{'x','x','x','x'},{'x','x','x','x'},{'x','x','x','x'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertFalse(BoggleIterative.matchWord("eye", grid));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testNoMatchWord2, total execution time: " + (endTime - startTime) );
    }

    @Test
    public void testNoMatchWord3() throws Exception {
        char[][] grid = {{'a','c','x','x'},{'x','b','x','x'},{'x','x','x','x'},{'x','x','x','x'}};
        final long startTime = System.currentTimeMillis();
        Assert.assertFalse(BoggleIterative.matchWord("abca", grid));
        final long endTime   = System.currentTimeMillis();
        System.out.println("testNoMatchWord3, total execution time: " + (endTime - startTime) );
    }

//    @Test
//    public void test() {
//        List<String> old = new LinkedList<String>();
//        old.add("a"); old.add("b");
//        List<String> newList = new LinkedList<String>();
//        for (String p : old) {
//            newList.add(p);
//        }
//        newList.add("c");
//        System.out.println("what!");
//    }

    @Test
    public void test_isNeighbor() {
        BoggleIterative.Position[] positions = new BoggleIterative.Position[]{new BoggleIterative.Position(0,0), new BoggleIterative.Position(1,1),
                                        new BoggleIterative.Position(2,1), new BoggleIterative.Position(3,1), new BoggleIterative.Position(3,2)};
        Assert.assertTrue(BoggleIterative.isNeighbor(positions[0], positions[1]));
        Assert.assertTrue(BoggleIterative.isNeighbor(positions[1], positions[2]));
        Assert.assertTrue(BoggleIterative.isNeighbor(positions[3], positions[4]));
        Assert.assertFalse(BoggleIterative.isNeighbor(positions[0], positions[2]));
    }
}
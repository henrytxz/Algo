package sedgy.sort.quicksort;

import org.junit.Assert;
import org.junit.Test;
import utility.MyArrayUtil;
import utility.Shuffle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class QuickTest extends Quick {

    private String[] A = {"K","R","A","T","E","L","E","P","U","I","M","Q","C","X","O","S"};
    private Integer[] a = new Integer[]{3,2,8,7,3,4,3,15,6};

    @Test
    public void testQuickSort() {
        File file = new File("resources/QuickSort.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            Integer[] A = list.toArray(new Integer[list.size()]);

            sort(A);

            Assert.assertTrue(MyArrayUtil.checkArrayIntegerSorted(A));

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testPartition() {
        partition(A, 0, 15);
        String[] B = {"E","C","A","I","E","K","L","P","U","T","M","Q","R","X","O","S"};
        Assert.assertArrayEquals(B, A);
    }

    @Test
    public void testPartitionWithDuplcateEntries() {

        int j = partition(a, 0, a.length-1);
        Assert.assertEquals(3, j);
        Integer[] b = {3,2,3,3,7,4,8,15,6};
        Assert.assertArrayEquals(b, a);
    }

    @Test
    public void testShuffle() {
        Shuffle.shuffle(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testExch() {
        Integer[] a = {3,1,2};
        exch(a, 0, 1);
        Assert.assertArrayEquals(new Integer[]{1,3,2}, a);
    }

    @Test
    public void testMore() {
        Assert.assertTrue(more("U", "Q"));
        Assert.assertFalse(more("A", "B"));
    }

    @Test
    public void testLess() {
        Assert.assertTrue(less("A", "B"));
        Assert.assertFalse(less("B", "A"));
    }
}
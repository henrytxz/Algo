package sedgy.quicksort;

import org.junit.Assert;
import org.junit.Test;
import utility.MyArrayUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class QuickTest extends Quick {

    private Integer[] a = {3,1,2};
    private String[] A = {"K","R","A","T","E","L","E","P","U","I","M","Q","C","X","O","S"};

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
    public void testExch() {
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
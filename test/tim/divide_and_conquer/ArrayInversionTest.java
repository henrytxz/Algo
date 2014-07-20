package tim.divide_and_conquer;

import junit.framework.Assert;
import org.junit.Test;
import utility.MyArrayUtil;
import utility.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * User: henry
 * Date: 8/18/13
 * Time: 11:36 AM
 */

public class ArrayInversionTest {

    @Test
    public void debugSortAndCount() throws Exception {
        File file = new File("resources/IntegerArray.txt");
        try {
//            System.out.println(Integer.MAX_VALUE);
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file,94650);      //94680
            System.out.println("list size:"+list.size());

            Integer[] A = MyArrayUtil.ListIntegersToIntegerArray(list);

            Pair<Integer[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            Integer[] D = D_total.getLeft();

            MyArrayUtil.checkArrayIntegerSorted(D);
            System.out.println("expect "+D_total.getRight()+" inversions");
            int expectedInversions = ArrayInversion.bruteForceCount(A);
//            System.out.println("expect "+expectedInversions+" inversions");
            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testSortAndCount() throws Exception {
        File file = new File("resources/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file,93000);

            Integer[] A = MyArrayUtil.ListIntegersToIntegerArray(list);

            Pair<Integer[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            Integer[] D = D_total.getLeft();

            MyArrayUtil.checkArrayIntegerSorted(D);

            int expectedInversions = ArrayInversion.bruteForceCount(A);
            System.out.println("-------------------------------------------");
            System.out.println("ArrayInversionTest.testSortAndCount() expect "+expectedInversions+" inversions");
            System.out.println("-------------------------------------------");
            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testBigIntegerSortAndCount() throws Exception {
        File file = new File("resources/IntegerArray.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            Integer[] A = MyArrayUtil.ListIntegersToIntegerArray(list);

            Pair<Integer[],Integer> D_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length-1);

            Integer[] D = D_total.getLeft();

            MyArrayUtil.checkArrayIntegerSorted(D);

            BigInteger expectedInversions = ArrayInversion.BigInteger_bruteForceCount(A);
            System.out.println("expect "+expectedInversions+" inversions");
//            Assert.assertEquals(expectedInversions, (int) D_total.getRight());

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testSmallExample() throws Exception {
//        int[] A = new int[]{5,2};

        Integer[] A = new Integer[]{1,3,5,2,4,6};

        Pair<Integer[], Integer> D_and_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length - 1);
        MyArrayUtil.checkArrayIntegerSorted(D_and_total.getLeft());
    }

    @Test
    public void test_bruteForceCount() throws Exception {
        System.out.println(Integer.MAX_VALUE);

        Integer[] A = new Integer[]{1,3,5,2,4,6};

        int i=0;
        int j=1;
        int l=6;
    //        System.out.println(i<j&&j<l);

        Assert.assertEquals(3, ArrayInversion.bruteForceCount(A));
    }

    @Test
    public void test_BigInteger_bruteForceCount() throws Exception {
        Integer[] A = new Integer[]{1,3,5,2,4,6};

        int i=0;
        int j=1;
        int l=6;

        Assert.assertEquals(3, ArrayInversion.BigInteger_bruteForceCount(A).intValue());
    }
}

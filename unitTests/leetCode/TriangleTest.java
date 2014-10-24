package leetCode;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleTest {

    @Test
    public void test() throws Exception {
        ArrayList<Integer> row0 = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(3,4));
        ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(6,5,7));
        ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(4,1,8,3));
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(Arrays.asList(row0,row1,row2,row3));
        Assert.assertEquals(11, Triangle.minimumTotal(triangle));
    }

    @Test
    public void test2() throws Exception {
        ArrayList<Integer> row0 = new ArrayList<Integer>(Arrays.asList(-1));
        ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(3,2));
        ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(-3,1,-1));
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(Arrays.asList(row0,row1,row2));
//        System.out.println(Triangle.minimumTotal(triangle));
        Assert.assertEquals(-1, Triangle.minimumTotal(triangle));
    }

    @Test
    public void test3() throws Exception {
        ArrayList<Integer> row0 = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(3,4));
        ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(6,5,9));
        ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(4,4,8,0));
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(Arrays.asList(row0,row1,row2,row3));
        Assert.assertEquals(14, Triangle.minimumTotal(triangle));
    }
}
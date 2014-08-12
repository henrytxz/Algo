package utility;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void test_search() throws Exception {
        int[] a = new int[] {1,2,3,4,5};
        Assert.assertEquals(0, BinarySearch.search(a, 1));
        Assert.assertEquals(1, BinarySearch.search(a, 2));
        Assert.assertEquals(2, BinarySearch.search(a, 3));
        Assert.assertEquals(3, BinarySearch.search(a, 4));
        Assert.assertEquals(4, BinarySearch.search(a, 5));
        Assert.assertEquals(-1, BinarySearch.search(a, 8));
    }
}
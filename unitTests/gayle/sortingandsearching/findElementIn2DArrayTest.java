package gayle.sortingandsearching;

import org.junit.Assert;
import org.junit.Test;

public class findElementIn2DArrayTest {

    @Test
    public void test_find() throws Exception {
        int[][] a = {{15,20,70,85},{20,35,80,95},{30,55,95,105},{40,80,100,120},{45,82,111,136}};
        Assert.assertTrue(  FindElementIn2DArray.find(a, 55) );
    }

    @Test
    public void test_find2() throws Exception {
        int[][] a = {{15,20,70,85},{20,35,80,95},{30,55,95,105},{40,80,100,120},{45,82,111,136}};
        Assert.assertFalse( FindElementIn2DArray.find(a, 33) );
    }
}
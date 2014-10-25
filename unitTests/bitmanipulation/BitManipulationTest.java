package bitmanipulation;

import junit.framework.Assert;
import org.junit.Test;

public class BitManipulationTest {

    @Test
    public void test_getBit() throws Exception {
        byte b = 2; //00000010
        Assert.assertTrue( BitManipulation.getBit(b, 1));
        Assert.assertFalse(BitManipulation.getBit(b, 0));
        for (int i=2; i!=8; i++) {
            Assert.assertFalse(BitManipulation.getBit(b, i));
            System.out.println(i+"th bit not set");
        }
    }

    @Test
    public void test_setBit() throws Exception {

    }
}
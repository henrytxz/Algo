package gayle.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

public class BitTest {

    @Test
    public void testGetBit() throws Exception {
        Assert.assertEquals(true, Bit.getBit(5, 2));
    }

    @Test
    public void testIsPowerOfTwo() {
        int x = 8;
        int y = 9;
        boolean isPowerOfTwo = Bit.isPowerOfTwo(x);
        Assert.assertEquals(true, isPowerOfTwo);
        Assert.assertEquals(8, x);
        Assert.assertEquals(false, Bit.isPowerOfTwo(y));

        Assert.assertEquals(true, Bit.myIsPowerOfTwo(x));
        Assert.assertEquals(false, Bit.myIsPowerOfTwo(y));
    }

    @Test
    public void testSetBit() throws Exception {
        Assert.assertEquals(15, Bit.setBit(15, 2)); //15 is 1111, an eg of ith bit already set
        Assert.assertEquals(7, Bit.setBit(5, 1));   //3 is 101,   an eg of ith bit not already set
        Assert.assertEquals(2, Bit.setBit(0,1));
    }

    @Test
    public void testZerothBitIsOne() {
        Assert.assertEquals(1, Bit.setBit(0,0));
    }

    @Test
    public void testClearBit() throws Exception {
        Assert.assertEquals(11, Bit.clearBit(15, 2)); //15 is 1111, should become 1011
        Assert.assertEquals(11, Bit.clearBit(11, 2)); //11 is 1011, should not change

        Assert.assertEquals(11, Bit.myClearBit(15, 2));
        Assert.assertEquals(11, Bit.myClearBit(11, 2));
    }

    @Test
    public void test_clearBitsAtLeastI() {
        Assert.assertEquals(1, Bit.clearBitsAtLeastI(15, 1));
        Assert.assertEquals(3, Bit.clearBitsAtLeastI(15, 2));
    }

    @Test
    public void test_clearBitsAtMostI() {
        Assert.assertEquals(12, Bit.clearBitsAtMostI(15, 1));
        Assert.assertEquals(8, Bit.clearBitsAtMostI(15, 2));

        Assert.assertEquals(12, Bit.myClearBitsAtMostI(15, 1));
        Assert.assertEquals(8, Bit.myClearBitsAtMostI(15, 2));
    }

/*
    @Test
    public void testUpdateBit() throws Exception {
        Assert.assertEquals(
    }*/
}
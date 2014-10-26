package progpearls;

import gayle.bitmanipulation.Bit;
import junit.framework.Assert;
import org.junit.Test;

public class Sort7DigitPhoneNumbersAccordingToEssayTest {
    int[] a = new int[10];

    static int SIZE_OF_BYTE = 8;
    static int SIZE_OF_INT  = 32;

    @Test
    public void test() {
        int number = 2;

        a[number/SIZE_OF_INT] = Bit.setBit(a[number/SIZE_OF_INT], number%SIZE_OF_INT);

        for (int i=0; i!=a.length; i++) {
            for (int j=0; j!=SIZE_OF_INT; j++) {
                if (Bit.getBit(a[i], j)) {
                    System.out.println(i * SIZE_OF_INT + j);
                }
            }
        }
    }

    @Test
    public void test_setBit0() {
        int i=0;
        i = Bit.setBit(i, 31);
        i = Bit.setBit(i, 0);
        Assert.assertTrue(Bit.getBit(i,31));
        Assert.assertTrue(Bit.getBit(i,0));
        Assert.assertFalse(Bit.getBit(i,1));
        Assert.assertFalse(Bit.getBit(i,2));
    }

    @Test
    public void test_setBit() {
        int number = 9999999;
        int i = number/SIZE_OF_INT;
        System.out.println("set "+number%SIZE_OF_INT+"th bit of a["+i+"]");
        System.out.println(Bit.setBit(0, number%SIZE_OF_INT));
        System.out.println(1<<31);
        System.out.println(Bit.setBit(0, 9999998%SIZE_OF_INT));
        System.out.println(new Double(Math.pow(2,31)).intValue());
        System.out.println(new Double(Math.pow(2,30)).intValue());
        System.out.println(99%32);
    }
}
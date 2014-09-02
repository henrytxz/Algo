package gayle.bitmanipulation;

/**
 * Created by henry on 9/2/2014.
 */
public class Bit {
    public static boolean getBit(int x, int i) {
        return ( (x & (1<<i))!=0 );
    }

    /**
     * left shift 1 by i bits
     * then OR with x => if x's ith bit is 0, it becomes 1; else it stays 1
     *
     * @param x, the number I may modify
     * @param i, the bit I will set if not set already
     * @return either x or x + setting the ith bit
     */
    public static int setBit(int x, int i) {
        return x | (1<<i);
    }

    public static int clearBit(int x, int i) {
        int y = ~(1<<i);
        return x & y;
    }

    /*
        it's called myClearBit because many other methods in this class are the same as Gayle's (I figured them out but still they are the same as Gayle's)
     */
    public static int myClearBit(int x, int i) {
        if (getBit(x,i))
            x -= Math.pow(2,i);
        return x;
    }

    public static int clearBitsAtLeastI(int x, int i) {
        return x & ((1<<i)-1);
    }

    public static int clearBitsAtMostI(int x, int i) {
        int mask = ~( ( (1<<(i+1)) - 1 ) );
        return x & mask;
    }

    public static int myClearBitsAtMostI(int x, int i) {
        for (int j = 0; j <= i; j++) {
            x = x >> 1;
        }
        x *= Math.pow(2, i + 1);
        return x;
    }

    public static int updateBit(int x, int i) {
        return -1;
    }

    public static boolean isPowerOfTwo(int x) {
        if (getBit(x, 0)) return false;

        int count=0;
        while (x!=0) {
            x = (x >> 1);
            if (getBit(x, 0)) count++;
        }
        return count==1;
    }
}

package bitmanipulation;

/**
 * Created by henry on 10/25/2014.
 */
public class BitManipulation {
    public static boolean getBit(byte b, int i) {
        return (b & 1<<i)!=0;
    }

    public static void setBit(int i) {

    }
}

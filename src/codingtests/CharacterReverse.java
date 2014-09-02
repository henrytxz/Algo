package codingtests;

import java.util.Scanner;

/**
 * Created by henry on 9/1/2014.
 */
public class CharacterReverse {

    /**
     *  9/2/2014: I hope they don't test it assuming I need to take care of capital T and H as well...
     *  this runs in linear time (single pass of the char array) and takes linear space (char array)
     */
    static String characterReverse(String input) {
        char[] a = input.toCharArray();

        //the index where the last sequence of t starts. For eg, ttth, t will be 0 even when I'm looking at later characters
        //-1 denotes no 't' found
        int tIndex = -1;

        for (int i=0; i<a.length; i++) {
            if (a[i]=='t' && !afterT(a, i)) //found t and it's the beginning of a new t sequence, update tIndex
            {
                tIndex = i;
            }
            else if (a[i]=='h' && afterT(a, i)) //found h following a t, swap h with the beginning of the t sequence, ttth => httt
            {
                swap(a, tIndex, i);
                tIndex++;
            }
        }
        return String.valueOf(a);
    }

    private static boolean afterT(char[] a, int i) {
        return i-1>=0 && a[i-1]=='t';
    }

    private static void swap(char[] a, int i, int j) {
        if (a==null) return;
        if (i<0 || i>=a.length) throw new ArrayIndexOutOfBoundsException();
        if (j<0 || j>=a.length) throw new ArrayIndexOutOfBoundsException();
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        _input = in.nextLine();

        res = characterReverse(_input);
        System.out.println(res);
    }
}

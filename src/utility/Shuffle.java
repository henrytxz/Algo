package utility;

import java.util.Random;

/**
 * Created by henry on 9/20/2014.
 * borrowing from Sedgewick StdRandom
 */
public class Shuffle {
    private static Random random;

    static {
        random = new Random();
    }

    public static void shuffle(Integer[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + uniform(N-i);     // between i and N-1
            System.out.println("swapping "+i+" and "+r);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    private static int uniform(int N) {
        if (N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
        return random.nextInt(N);
    }
}

package mockinterviews;

/**
 * Created by henry on 9/14/2014.
 * goal: print fibonacci numbers
 * constraints: do not use a loop
 */
public class Fibonacci {
    private int[] a;

    private int fib(int i) {
        assert (i>=0);

        if (a[i]==0) {
            if (i==0 || i==1) {
                a[i] = 1;
            } else {
                a[i] = fib(i - 2) + fib(i - 1);
            }
            System.out.println(a[i]);
        }

        return a[i];
    }

    public Fibonacci(int numberTerms) {
        if (numberTerms<2) throw new IllegalArgumentException("expect at least 2 terms for a Fibonacci sequence");
        a = new int[numberTerms];
    }

    public void print() {
        fib(a.length-1);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(7);
        f.print();
    }
}

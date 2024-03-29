package interviews;

/**
 * Created by henry on 9/14/2014.
 * goal: print fibonacci numbers in reverse order
 * constraints: do not use a loop
 */
public class FibonacciReverse {
    private int[] a;

    private int fib(int i) {
        assert (i>=0);

        if (a[i]==0) {
            if (i==0 || i==1) {
                a[i] = 1;
            } else {
                a[i] = fib(i - 2) + fib(i - 1);
            }
        }

        return a[i];
    }

    public FibonacciReverse(int numberTerms) {
        if (numberTerms<2) throw new IllegalArgumentException("expect at least 2 terms for a Fibonacci sequence");
        a = new int[numberTerms];
    }

    private void print(int i) {
        if (i>0) {
            System.out.println(fib(i-1));
            print(i-1);
        }
    }

    public void print() { print(a.length); }

    public static void main(String[] args) {
        FibonacciReverse f = new FibonacciReverse(7);
        f.print();
    }
}

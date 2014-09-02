package mockinterviews;

import org.junit.Test;

public class PrintUniqueTest {

    @Test
    public void testPrintUnique() throws Exception {
        int[] a = new int[]{3,2,1,2};
        PrintUnique.printUnique(a);
    }
}
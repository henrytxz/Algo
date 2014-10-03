package gayle.sortingandsearching;

import org.junit.Test;

import java.util.ArrayList;

public class CircusTowerTest {
    @Test
    public void test() {
        ArrayList<Htwt> items = new ArrayList<Htwt>();

        items.add(new Htwt(1,  9));
        items.add(new Htwt(2, 14));
        items.add(new Htwt(3, 10));
        items.add(new Htwt(4, 11));
        items.add(new Htwt(5, 12));

        ArrayList<Htwt> result = CircusTower.getIncreasingSequence(items);
        for (Htwt htwt : result) {
            System.out.println(htwt);
        }
    }

}
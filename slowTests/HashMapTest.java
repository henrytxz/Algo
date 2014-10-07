import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HashMapTest {

    private HashMap<Integer, Character> hm = new HashMap<Integer, Character>();

    @Test
    public void testResizeExpand() {
        hm = new HashMap<Integer, Character>();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for (int i=0;i!=7;i++) {
            ints.add(i);
        }
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c='a';c!='h';c++) {
            chars.add(c);
        }

        for (int i=0;i!=ints.size();i++) {
            hm.put(i, chars.get(i));
        }
        Assert.assertEquals(7, hm.getNumberOfEntries());
        Assert.assertEquals(16, hm.getNumberOfBuckets());
    }

    @Test
    public void testResizeShrink() {
        HashMap<SillyChar, Integer> hms = new HashMap<SillyChar, Integer>();
        ArrayList<SillyChar> chars = new ArrayList<SillyChar>();
        for (char c='a';c!='h';c++) {
            chars.add(new SillyChar(c));
        }
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for (int i=0;i!=7;i++) {
            ints.add(i);
        }

        for (int i=0;i!=ints.size();i++) {
//            if (i==3)
//                System.out.println("pause");
            hms.put(chars.get(i), i);
        }

        hms.print();

        hms.remove(new SillyChar('a'));
        hms.remove(new SillyChar('b'));
        Assert.assertEquals(5, hms.getNumberOfEntries());
//        Assert.assertEquals(16, hms.getNumberOfBuckets());
    }

    private class SillyChar {
        Character c;
        SillyChar(char c) { this.c = c; }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof SillyChar)) return false;
            return c.equals(((SillyChar) obj).c);
        }

        /**
         *  being deliberately silly and always return 17
         */
        @Override
        public int hashCode() {
            return 17;
        }

        public String toString() {return c.toString();}
    }

    @Test
    public void testHashToNonNegativeIndex() {
        try {
            hm.put(-1,'z');
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail();
        }
    }

    @Test
    public void testOverwriteValueIfSameKey() {
        hm.put(1,'b');
        hm.put(1,'a');
        Assert.assertEquals('a', hm.get(1).charValue());
    }
}
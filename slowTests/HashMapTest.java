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

        for (int i=0;i!=7;i++) {
            Assert.assertEquals(chars.get(i), hm.get(ints.get(i)));
        }

        Assert.assertNull(hm.get(7));
    }

    /**
     * a custom data type that always collide and hence useful for the next test, testResizeShrink()
     */
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
            hms.put(chars.get(i), i);
        }

        hms.remove(new SillyChar('a'));
        hms.remove(new SillyChar('b'));
        Assert.assertNull(hms.get(new SillyChar('a')));
        Assert.assertNull(hms.get(new SillyChar('b')));
        for (int i=2;i!=7;i++) {
            Assert.assertEquals(ints.get(i), hms.get(chars.get(i)));
        }
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
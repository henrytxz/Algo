package sedgy.hashtable;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HashMapTest {

    private HashMap<Integer, Character> hm = new HashMap<Integer, Character>();

//    @Before
//    public void setUp()
//    {
//
//    }

    @Test
    public void testResize() {
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
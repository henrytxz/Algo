package sedgy.hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SeparateChainingHashSTTest extends TestCase {

    private SeparateChainingHashST<Integer, String> hashTable = new SeparateChainingHashST<Integer, String>();

    public void test() throws Exception {
        hashTable.put(1, "hey!");
        hashTable.put(2, "hello!");
        hashTable.put(3, "hi!");
        Assert.assertEquals("hi!", hashTable.get(3));
    }


}
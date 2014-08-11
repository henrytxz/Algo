package sedgy.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BSTTest {

    /*
        similar to BST.main
    */
    @Test
    public void testPut() throws Exception {
        BST<String, Integer> st = new BST<String, Integer>();

        String[] testCase = {"S","E","A","R","C","H","E","X","A","M","P","L","E"};
        for (int i=0; i<testCase.length; i++) {
            st.put(testCase[i], i);
        }

        List<String> result = new ArrayList<String>();

        for (String s : st.keys())
            result.add(s);

        Assert.assertArrayEquals(new String[]{"A","C","E","H","L","M","P","R","S","X"}, result.toArray(new String[result.size()]));
    }
}
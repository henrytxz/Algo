package gayle.treesandgraphs;

import junit.framework.Assert;
import org.junit.Test;

public class IsBalancedTest {

    @Test
    public void test_isBalanced() throws Exception {
        Node a = new Node(12);
        a.left = new Node(7);
        a.right = new Node(4);
        Node b = a.right;
        b.left = new Node(5);
        Assert.assertTrue(IsBalanced.isBalanced(a));
    }

    @Test
    public void test_isNotBalanced() throws Exception {
        Node a = new Node(1);
        a.left = new Node(2);
        Node b = a.left;
        b.left = new Node(3);
        Assert.assertFalse(IsBalanced.isBalanced(a));
    }
}
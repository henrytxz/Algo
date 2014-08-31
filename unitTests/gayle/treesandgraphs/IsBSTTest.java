package gayle.treesandgraphs;

import junit.framework.Assert;
import org.junit.Test;

public class IsBSTTest {

    @Test
    public void test_isBST1() throws Exception {
        Node a = new Node(8);
        a.left = new Node(5);
        a.right = new Node(11);
        Node b = a.left;
        b.left = new Node(2);
        b.right = new Node(6);
        Node c = b.right;
        c.right = new Node(7);
        Assert.assertTrue(IsBST.isBST(a));
    }

    @Test
    public void test_isBST2() throws Exception {
        Node a = new Node(8);
        a.left = new Node(5);
        a.right = new Node(11);
        Node b = a.left;
        b.left = new Node(2);
        b.right = new Node(-6); //boom
        Node c = b.right;
        c.right = new Node(7);
        Assert.assertFalse(IsBST.isBST(a));
    }

    @Test
    public void test_isBST3() throws Exception {
        Node a = new Node(8);
        a.left = new Node(5);
        a.right = new Node(1);
        Node b = a.left;
        b.left = new Node(2);
        b.right = new Node(6);
        Node c = b.right;
        c.right = new Node(7);
        Assert.assertFalse(IsBST.isBST(a));
    }
}
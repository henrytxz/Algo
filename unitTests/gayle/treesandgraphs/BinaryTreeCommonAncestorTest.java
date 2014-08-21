package gayle.treesandgraphs;

import org.junit.Test;

public class BinaryTreeCommonAncestorTest {

    @Test
    public void testFind() throws Exception {
        Node a = new Node(5);
        a.left = new Node(4);
        a.right = new Node(6);
        Node b = a.right;
        b.left = new Node(3);
        b.right = new Node(2);
        Node c = b.left;
        c.left = new Node(0);
        c.right = new Node(1);

        Node result = BinaryTreeCommonAncestor.find(a, 1, 2);
        System.out.println(result);
    }
}
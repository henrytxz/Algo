package leetCode;

import org.junit.Test;

import java.util.List;

public class PostOrderTreeTraversalTest {
    @Test
    public void test() {
        TreeNode n = new TreeNode(1);
        n.left = null;
        n.right = new TreeNode(2);

        PostOrderTreeTraversal.postorderTraversal(n);
    }

    @Test
    public void test2() {
        TreeNode n = new TreeNode(7);
        n.left  = new TreeNode(3);
        n.right = new TreeNode(6);
        n.left.left  = new TreeNode(1);
        n.left.right = new TreeNode(2);
        n.right.left  = new TreeNode(4);
        n.right.right = new TreeNode(5);

        List<Integer> l = PostOrderTreeTraversal.postorderTraversal(n);
        for (Integer i : l) {
            System.out.println(i);
        }
    }

    @Test
         public void test3() {
        TreeNode n = new TreeNode(3);
        n.left  = new TreeNode(1);
        n.right = new TreeNode(2);

        List<Integer> l = PostOrderTreeTraversal.postorderTraversal(n);
        for (Integer i : l) {
            System.out.println(i);
        }
    }

    @Test
    public void test4() {
        TreeNode n = new TreeNode(2);
        n.right = new TreeNode(3);
        n.right.right = new TreeNode(1);

        List<Integer> l = PostOrderTreeTraversal.postorderTraversal(n);
        for (Integer i : l) {
            System.out.println(i);
        }
    }
}
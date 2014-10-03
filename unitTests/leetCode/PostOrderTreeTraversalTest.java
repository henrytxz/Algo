package leetCode;

import org.junit.Test;

import java.util.List;

public class PostOrderTreeTraversalTest {
    @Test
    public void test() {
        PostOrderTreeTraversal.TreeNode n = new PostOrderTreeTraversal.TreeNode(1);
        n.left = null;
        n.right = new PostOrderTreeTraversal.TreeNode(2);

        PostOrderTreeTraversal.postorderTraversal(n);
    }

    @Test
    public void test2() {
        PostOrderTreeTraversal.TreeNode n = new PostOrderTreeTraversal.TreeNode(7);
        n.left  = new PostOrderTreeTraversal.TreeNode(3);
        n.right = new PostOrderTreeTraversal.TreeNode(6);
        n.left.left  = new PostOrderTreeTraversal.TreeNode(1);
        n.left.right = new PostOrderTreeTraversal.TreeNode(2);
        n.right.left  = new PostOrderTreeTraversal.TreeNode(4);
        n.right.right = new PostOrderTreeTraversal.TreeNode(5);

        List<Integer> l = PostOrderTreeTraversal.postorderTraversal(n);
        for (Integer i : l) {
            System.out.println(i);
        }
    }

    @Test
         public void test3() {
        PostOrderTreeTraversal.TreeNode n = new PostOrderTreeTraversal.TreeNode(3);
        n.left  = new PostOrderTreeTraversal.TreeNode(1);
        n.right = new PostOrderTreeTraversal.TreeNode(2);

        List<Integer> l = PostOrderTreeTraversal.postorderTraversal(n);
        for (Integer i : l) {
            System.out.println(i);
        }
    }

    @Test
    public void test4() {
        PostOrderTreeTraversal.TreeNode n = new PostOrderTreeTraversal.TreeNode(2);
        n.right = new PostOrderTreeTraversal.TreeNode(3);
        n.right.right = new PostOrderTreeTraversal.TreeNode(1);

        List<Integer> l = PostOrderTreeTraversal.postorderTraversal(n);
        for (Integer i : l) {
            System.out.println(i);
        }
    }
}
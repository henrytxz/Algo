package gayle.treesandgraphs;

/**
 * Created by henry on 8/22/2014.
 */
public class IsBST {
    public static boolean isBST(Node root) {
        if (root==null) return true;    //could just as well return false
        return pso(root).isBST;
    }

    /*
        pso stands for post order
     */
    private static Result pso(Node n) {
        Result left;
        Result right;
        int min = n.val;
        int max = n.val;
        if (n.left!=null) {
            left = pso(n.left);
            if (!left.isBST) return new Result(false);
            if (left.max > n.val) return new Result(false);
            min = left.min;
        }
        if (n.right!=null) {
            right = pso(n.right);
            if (!right.isBST) return new Result(false);
            if (right.min < n.val) return new Result(false);
            max = right.max;
        }
        return new Result(true, min, max);
    }

    private static class Result {
        boolean isBST;
        Integer min;
        Integer max;

        private Result(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }

        /*
            I'm being lazy here by providing a way to not worry about min and max when isBST is false
            a subtree is not a BST implies the whole tree is not a BST and therefore min and max no longer need to be carried/updated
         */
        private Result(boolean isBST) {
            this.isBST = isBST;
        }
    }
}

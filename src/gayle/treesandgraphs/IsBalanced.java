package gayle.treesandgraphs;

/**
 * Created by henry on 8/23/2014.
 */
public class IsBalanced {
    public static boolean isBalanced(Node n) {
        return pso(n).isBalanced;
    }

    /*
        pso short for post order
    */
    private static Result pso(Node n) {
        if (n==null) return new Result(true, -1);	//so a leaf can be height 0
        Result l = pso(n.left);
        Result r = pso(n.right);
        if ( !l.isBalanced || !r.isBalanced ) return new Result(false);
        if (Math.abs(l.height-r.height)>1)
            return new Result(false);
        return new Result(true, Math.max(l.height,r.height)+1);
    }

    private static class Result {
        private boolean isBalanced;
        private int height;
        private Result(boolean isBalanced) {
            this.isBalanced = isBalanced;
        }
        private Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}

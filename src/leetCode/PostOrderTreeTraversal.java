package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by henry on 10/3/2014.
 */
public class PostOrderTreeTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        addLeftDescendents(root, st);
        TreeNode curr;
        while (!st.isEmpty()) {
            curr = st.peek();
            if (curr.right!=null) {
                if (l.size()==0 || (l.size()>0 && !l.get(l.size()-1).equals(curr.right.val)))  {
                    addLeftDescendents(curr.right, st);
                    curr = st.peek();
                }
            }
            if (curr.right==null || (l.size()>0 && l.get(l.size()-1).equals(curr.right.val))) {
                l.add(st.pop().val);
            }
        }
        return l;
    }

    private static void addLeftDescendents(TreeNode root, Stack<TreeNode> st) {
        TreeNode n = root;
        while (n!=null) {
            st.push(n);
            n = n.left;
        }
    }
}

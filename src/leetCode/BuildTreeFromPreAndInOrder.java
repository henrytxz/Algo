package leetCode;

import java.util.ArrayList;

/**
 * Created by henry on 10/3/2014.
 */
public class BuildTreeFromPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null  || inorder==null) return null;
        if (preorder.length != inorder.length) return null;

        int curr = preorder[0];
        TreeNode root = new TreeNode(curr);
        if (preorder.length==1) return root;

        int count = 0;
        while (inorder[count]!=curr) {
            count++;
        }

        ArrayList<Integer> alPre = new ArrayList<Integer>();
        ArrayList<Integer> alIn  = new ArrayList<Integer>();
        int i=1;
        int j=0;

        while (inorder[j]!=curr) {
            alPre.add(preorder[i++]);
            alIn.add(inorder[j++]);
        }

        root.left = buildTree(alPre.toArray(new Integer[alPre.size()]), alIn.toArray(new Integer[alIn.size()]));

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = subArray(a, 0, 2);
        for (int i : b) {
            System.out.println(i);
        }
    }

    private static int[] subArray(int[] a, int begin, int len) {
        int[] result = new int[len];
        System.arraycopy(a, begin, result, 0, len);
        return result;
    }

    //        for (int i=0; i<a.length; i++) {
    //            result[i] = a[i];
    //        }

}

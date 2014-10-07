package leetCode;

/**
 * Created by henry on 10/3/2014.
 */
public class BuildTreeFromPreAndInOrder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null  || inorder==null) return null;
        if (preorder.length != inorder.length) return null;

        int curr = preorder[0];
        TreeNode root = new TreeNode(curr);
        if (preorder.length==1) return root;

        int count = 0;
        while (inorder[count]!=curr) {
            count++;
        }

        int[] leftPreOrder = new int[count];
        System.arraycopy(preorder, 1, leftPreOrder, 0, count);
        int[] leftInOrder  = new int[count];
        System.arraycopy(inorder, 0, leftInOrder, 0, count);
        root.left = buildTree(leftPreOrder, leftInOrder);

        int rightLen = preorder.length-1-count;
        int[] rightPreOrder = new int[rightLen];
        System.arraycopy(preorder, count+1, rightPreOrder, 0, rightLen);
        int[] rightInOrder  = new int[rightLen];
        System.arraycopy(inorder, count+1, rightInOrder, 0, rightLen);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{2,1,3};
        TreeNode root = buildTree(a, b);
        System.out.println("pause");
    }
}

package gayle.treesandgraphs;

/**
 * Created by henry on 9/29/2014.
 */
public class MinHeightBSTFromSortedArray<T> {

    private BinTreeNode<T> root;

    public MinHeightBSTFromSortedArray(T[] a) {
        root = buildBST(a, 0, a.length-1);
    }

    public BinTreeNode<T> getTree() {
        return root;
    }

    private BinTreeNode<T> buildBST(T[] a, int lo, int hi) {
        if (hi<lo) return null;
        int mid = (lo+hi+1)/2;
        BinTreeNode<T> result = new BinTreeNode<T>(a[mid]);
        if (lo==hi) return result;
        result.setLeft(buildBST(a, lo, mid-1));
        result.setRight(buildBST(a, mid+1, hi));
        return result;
    }
}

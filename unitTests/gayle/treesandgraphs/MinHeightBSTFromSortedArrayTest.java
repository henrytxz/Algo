package gayle.treesandgraphs;

import org.junit.Test;

public class MinHeightBSTFromSortedArrayTest {
    @Test
    public void test() {
        Integer[] a = new Integer[]{1,2,3,4,5,6,7,8};
        MinHeightBSTFromSortedArray<Integer> bst = new MinHeightBSTFromSortedArray<Integer>(a);
        BinTreeNode<Integer> tree = bst.getTree();
        System.out.println(tree);
    }

    @Test
    public void test_print1() {
        Integer[] a = new Integer[]{1,2,3,4,5,6,7};
        MinHeightBSTFromSortedArray<Integer> bst = new MinHeightBSTFromSortedArray<Integer>(a);
        BinTreeNode<Integer> tree = bst.getTree();

        tree.print();
    }

    @Test
    public void test_print2() {
        Integer[] a = new Integer[]{1,2,3,4,5,6,7,8};
        MinHeightBSTFromSortedArray<Integer> bst = new MinHeightBSTFromSortedArray<Integer>(a);
        BinTreeNode<Integer> tree = bst.getTree();

        tree.print();
    }
}
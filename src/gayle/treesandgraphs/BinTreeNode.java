package gayle.treesandgraphs;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by henry on 8/20/2014.
 * learn to use an inner class properly
 */
public class BinTreeNode<T> {
    private T val;
    private BinTreeNode<T> left;
    private BinTreeNode<T> right;

    private StringBuilder sb;

    public BinTreeNode(T val) {
        this.val = val;
    }

    public void setLeft(BinTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinTreeNode<T> right) {
        this.right = right;
    }

    public T getVal() {return val;}
    public BinTreeNode getLeft() {return left;}
    public BinTreeNode getRight() {return right;}

    public void print() {
        edu.princeton.cs.algs4.Queue<BinTreeNode<T>> q = new edu.princeton.cs.algs4.Queue<BinTreeNode<T>>();
        q.enqueue(this);
//        populateQueue(q, this);
        populateQueue(q, 1, 0);

//        int numberOfNodesAtThisLevel = 1;
//
//        while (!q.isEmpty()) {
//            for (int i=0; i<numberOfNodesAtThisLevel&&!q.isEmpty(); i++) {
//                System.out.print(q.dequeue()+" ");
//            }
//            System.out.println();
//            numberOfNodesAtThisLevel*=2;
//        }
    }

//    private void populateQueue(Queue<T> q, BinTreeNode<T> node) {

    private void populateQueue(Queue<BinTreeNode<T>> q, int numberOfNodesAtThisLevel, int numberOfNodesPrintedFromThisLevel) {
        BinTreeNode<T> node;
        while (!q.isEmpty()) {
            node = q.dequeue();
            System.out.print(node.val+" ");
            numberOfNodesPrintedFromThisLevel++;
            if (numberOfNodesAtThisLevel==numberOfNodesPrintedFromThisLevel) {
                System.out.println();
                numberOfNodesAtThisLevel*=2;
                numberOfNodesPrintedFromThisLevel=0;
            }
            if (node.left!=null) {
                q.enqueue(node.left);
            }
            if (node.right!=null) {
                q.enqueue(node.right);
            }
            populateQueue(q, numberOfNodesAtThisLevel, numberOfNodesPrintedFromThisLevel);
        }

//        for (T node : q) {
//
//        }

//            populateQueue(q, node.left);
//            populateQueue(q, node.right);
    }

    public String toString() {
        sb = new StringBuilder();
        constructString(this);
        return sb.toString();
    }

    /**
     *  in-order
     */
    private void constructString(BinTreeNode<T> node) {
        if (node.left!=null) {
            constructString(node.left);
        }
        sb.append(node.val);
        sb.append(" ");
        if (node.right!=null) {
            constructString(node.right);
        }
    }
}

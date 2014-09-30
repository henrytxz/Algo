package interviews;

/**
 * Created by henry on 8/20/2014.
 * learn to use an inner class properly
 */
public class Node<T> {
    private T val;
    private Node left;
    private Node right;

    public Node(T val) {
        this.val = val;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getVal() {return val;}
    public Node getLeft() {return left;}
    public Node getRight() {return right;}
}

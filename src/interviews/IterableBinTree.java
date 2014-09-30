package interviews;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by henry on 9/29/2014.
 */
public class IterableBinTree implements Iterable<Node> {

    private Node root;

    public IterableBinTree(Node root) {
        this.root = root;
    }

    @Override
    public Iterator<Node> iterator() {
        return new InOrder();
    }

    private class InOrder implements Iterator<Node> {

        Stack<Node> s;

        InOrder() {
            s = new Stack<Node>();
            pushCurrAndLeftChildren(root);
        }

        void pushCurrAndLeftChildren(Node curr) {
            while (curr!=null) {
                s.push(curr);
                curr = curr.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !s.empty();
        }

        @Override
        public Node next() {
            if (!hasNext()) throw new NoSuchElementException("all nodes have been visited!");
            Node result = s.pop();
            pushCurrAndLeftChildren(result.getRight());
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

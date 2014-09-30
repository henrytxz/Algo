package interviews;

import org.junit.Test;

public class IterableBinTreeTest {

    @Test
    public void test1() throws Exception {
        Node c = new Node<Character>('c');
        Node b = new Node<Character>('b');
        Node g = new Node<Character>('g');
        c.setLeft(b);
        c.setRight(g);

        b.setLeft(new Node<Character>('a'));

        Node e = new Node<Character>('e');
        g.setLeft(e);
        g.setRight(new Node<Character>('h'));

        e.setLeft(new Node<Character>('d'));
        e.setRight(new Node<Character>('f'));

        IterableBinTree cbt = new IterableBinTree(c);
        for (Node n : cbt) {
            System.out.println(n.getVal());
        }
    }

    @Test
    public void test2() throws Exception {
        Node c = new Node<Integer>(3);
        Node b = new Node<Integer>(2);
        Node g = new Node<Integer>(7);
        c.setLeft(b);
        c.setRight(g);

        b.setLeft(new Node<Integer>(1));

        Node e = new Node<Integer>(5);
        g.setLeft(e);
        g.setRight(new Node<Integer>(8));

        e.setLeft(new Node<Integer>(4));
        e.setRight(new Node<Integer>(6));

        IterableBinTree cbt = new IterableBinTree(c);
        for (Node n : cbt) {
            System.out.println(n.getVal());
        }
    }
}
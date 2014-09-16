package coreJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by henry on 9/16/2014.
 */
public class PlayWithMap {
    @Test
    public void test() {
        Node n = new Node("n1", 1.01);
        Map<String, Node> m = new HashMap<String, Node>();
        m.put(n.key, n);
        double newValue = 1.0;
//        System.out.println("change is "+(newValue-n.value));
        n.value = newValue;
        Assert.assertEquals(1.0, m.get("n1").value, 1e-6);
//        m.put(n.key, n);
    }

    private static class Node {
        String key;
        double value;

        public Node(String key, double value) {
            this.key = key;
            this.value=value;
        }
    }
}

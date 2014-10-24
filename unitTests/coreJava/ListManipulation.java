package coreJava;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by henry on 10/9/2014.
 */
public class ListManipulation {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.remove(0);
        System.out.println(l.get(0));

        List<List<Integer>> result = new LinkedList<List<Integer>>();
    }
}

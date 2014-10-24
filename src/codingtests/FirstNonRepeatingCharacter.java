package codingtests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by henry on 9/1/2014.
 */
public class FirstNonRepeatingCharacter {

    static String firstNonRepeatingCharacter(String input) {
        if (input==null || input.length()==0) return "you've entered an empty string";
        char[] a = input.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<a.length; i++) {
            Integer count = map.get(a[i]);
            if (count==null) {
                map.put(a[i],1);
            } else {
                count++;
                map.put(a[i], count);
            }
        }

        for (int i=0; i<a.length; i++) {
            Integer count = map.get(a[i]);
            if (count==1) {
                return String.valueOf(a[i]);
            }
        }

        return "no unique character";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        _input = in.nextLine();

        res = firstNonRepeatingCharacter(_input);
        System.out.println(res);

//        Map<Character, Integer> map = new sedgy.hashtable.HashMap<Character, Integer>();
//        map.put('c', 3);
//
//        Integer count = map.get('h');
//        if (count==null) System.out.println("count is null");
//
//        count = map.get('c');
//        count++;
//        System.out.println(count);
    }

}

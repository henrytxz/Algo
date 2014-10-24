package leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by henry on 10/19/2014.
 */
public class WordLadder {
    public static int ladderLength(String start, String end, Set<String> dict) {
        List<String> words = new LinkedList<String>();
        List<Integer> dist = new LinkedList<Integer>();
        words.add(start);
        dist.add(1);
        dict.remove(start);
        while (words.size()!=0) {
            String curr = words.remove(0);
            int d = dist.remove(0);
            if (curr.equals(end)) return d;

            for(int i=0; i<curr.length(); i++){
                char[] currCharArr = curr.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        words.add(newWord);
                        dist.add(d+1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    private static boolean differByOneLetter(String a, String b) {
        if (a.length()!=b.length()) return false;
        int diff=0;
        for (int i=0; i!=a.length(); i++) {
            if (a.charAt(i)!=b.charAt(i)) {
                diff++;
                if (diff>1) return false;
            }
        }
        return diff==1;
    }
}

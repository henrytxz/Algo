package gayle.recursionandDP;

import java.util.Set;

/**
 * Created by henry on 9/30/2014.
 * question 9.6 on p110
 */
public class ValidParentheses {
    public static void validParen(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i!=n; i++) {
            sb.append("()");
        }
        Set<String> allPermutations = StringPermutation.allPermutation(sb.toString());
        for (String s : allPermutations) {
            if (isValidParenthesis(s)) System.out.println(s);
        }
    }

    public static boolean isValidParenthesis(String s) {
        int openParen = 0;
        int closeParen = 0;
        for (int i=0; i!=s.length(); i++) {
            if (s.charAt(i)=='(') openParen++;
            if (s.charAt(i)==')') closeParen++;
            if (closeParen>openParen) return false;
        }
        return true;
    }
}

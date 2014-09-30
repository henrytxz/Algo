package gayle.recursionandDP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by henry on 9/30/2014.
 * question 9.5 on p109
 */
public class StringPermutation {

    public static Set<String> allPermutation(String s) {
        Set<String> result = new HashSet<String>();
        if (s==null||s.length()==0) {
            result.add("");
            return result;
        }

        Set<String> smallSet = allPermutation(s.substring(1));
        StringBuilder sb = new StringBuilder();

        for (String shortS : smallSet) {
            for (int i=0; i!=shortS.length()+1; i++) {
                sb.append(shortS.substring(0,i));
                sb.append(s.substring(0,1));
                sb.append(shortS.substring(i));
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }

}

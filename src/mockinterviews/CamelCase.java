package mockinterviews;

import java.util.*;

/**
 * Created by henry on 9/6/2014.
 */
public class CamelCase {
    private Map<String, String> d;  //maps word to its definition
    private List<List<String>> goodParsings;
    private String s;

    public CamelCase(Map<String, String> d, String s) {
        this.d = d;
        this.s = s;
        goodParsings = new LinkedList<List<String>>();
    }

    public List<String> getCamelCase() {
        if (s==null || s.length()==0) return null;
        nextWord(s, null);
        List<String> result = new ArrayList<String>(goodParsings.size());
        for (List<String> goodParsing : goodParsings) {
            StringBuilder sb = new StringBuilder();
            for (String word : goodParsing) {
                sb.append(capitalizeFirstLetter(word));
            }
            result.add(sb.toString());
        }
        return result;
    }

    private String capitalizeFirstLetter(String word) {
        if (word==null || word.length()==0) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private void nextWord(String rest, List<String> seen) {
        if (d.containsKey(rest)) //todo consider other possible edge cases
        {
            List<String> oneParsing = new LinkedList<String>(seen);
            oneParsing.add(rest);
            goodParsings.add(oneParsing);
            seen = null;
        }

        for (int i=1; i<rest.length(); i++)   //length-1 because the whole rest as a string is already considered above
        {
            String firstPart = rest.substring(0, i);
            if (d.containsKey(firstPart)) {
                if (seen==null) seen = new LinkedList<String>();
                seen.add(firstPart);
                nextWord(rest.substring(i), seen);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> d = new HashMap<String, String>();
        d.put("good", "dummy definition");

//        d.put("goo", "dummy definition");
//        d.put("d", "dummy definition");

        d.put("go", "dummy definition");

        d.put("feed", "dummy definition");
        d.put("back", "dummy definition");
        d.put("feedback", "dummy definition");

//        CamelCase cc0 = new CamelCase(d, "good");
//        System.out.println(cc0.getCamelCase());

        CamelCase cc1 = new CamelCase(d, "goodfeedback");
        System.out.println(cc1.getCamelCase());
//
//        CamelCase cc2 = new CamelCase(d, "privac");
//        System.out.println(cc2.getCamelCase());
    }
}

package mockinterviews;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by henry on 9/14/2014.
 */
public class CamelCaseShort {
    private Map<String, String> d;

    public CamelCaseShort(Map<String, String> d) {this.d = d;}

    public List<String> camelCase(String s) {
        if (s==null) return null;
        List<String> l = new LinkedList<String>();
        if (s.length()==0) {l.add("");}
        for (int i=1;i!=s.length()+1;i++) {
            if (d.containsKey(s.substring(0,i))) {
                List<String> rest = camelCase(s.substring(i));
                for (String s0 : rest) {
                    l.add(capFirstLetter(s.substring(0,i))+s0);
                }
            }
        }
        return l;
    }

    public List<String[]> parse(String s) {
        List<String> strings = parseCommaSeparated(s);
        List<String[]> result = new LinkedList<String[]>();
        for (String s0 : strings) {
            result.add(s0.split(","));
        }
        return result;
    }

    private List<String> parseCommaSeparated(String s) {
        if (s==null) return null;
        List<String> l = new LinkedList<String>();
        if (s.length()==0) {l.add("");}
        for (int i=1;i!=s.length()+1;i++) {
            if (d.containsKey(s.substring(0,i))) {
                List<String> rest = parseCommaSeparated(s.substring(i));
                if (rest.size()>0) {
                    for (String s0 : rest) {
                        l.add(capFirstLetter(s.substring(0,i))+","+s0);
                    }
                }
            }
        }
        return l;
    }

    public String getFirst(String s) {
        String r="";
        if (d.containsKey(s)) {return capFirstLetter(s);}
        for (int i=1;i<s.length();i++) {
            if (d.containsKey(s.substring(0,i))) {
                String rest = getFirst(s.substring(i));
                if (rest!=null&&rest.length()>0) {
                    return capFirstLetter(s.substring(0,i))+rest;
                }
            }
        }
        return r;
    }

    private String capFirstLetter(String s) {
        //todo edge cases
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }


    public static void main(String[] args) {
        Map<String, String> d = new HashMap<String, String>();
        d.put("feed", "dummy definition");
        d.put("back", "dummy definition");
        d.put("good", "dummy definition");
        d.put("feedback", "dummy definition");
        d.put("go", "dummy definition");
        d.put("goo", "dummy definition");

//        CamelCaseShort cc0 = new CamelCaseShort(d, "good");
//        System.out.println(cc0.getCamelCaseShort());

        CamelCaseShort cc1 = new CamelCaseShort(d);
        System.out.println(cc1.camelCase("goodfeedback"));

        CamelCaseShort cc2 = new CamelCaseShort(d);
        System.out.println(cc2.camelCase("odfeedback"));
    }
}

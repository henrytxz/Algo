package gayle.arraysandstrings;

/**
 * Created by henry on 8/17/2014.
 */
public class StringReplaceChar {
    public static String replace(String s, int nonNullChars) {
        char[] a = s.toCharArray();
        int spaces = 0;
        for (int i=0; i<a.length; i++) {
            if (a[i]==' ') spaces++;
        }
        for (int j=nonNullChars-1; j>-1; j--) {
            if (a[j]==' ') {
                a[j+spaces*2]='0';
                a[j+spaces*2-1]='2';
                a[j+spaces*2-2]='%';
                spaces--;
            } else {
                a[j+spaces*2] = a[j];
            }
        }
        return new String(a);
    }
}

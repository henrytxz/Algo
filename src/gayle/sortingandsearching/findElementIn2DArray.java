package gayle.sortingandsearching;

/**
 * Created by henry on 8/19/2014.
 */
public class FindElementIn2DArray {
    public static boolean find(int[][] a, int x) {
        if (a==null||a.length==0||a[0].length==0) return false;
        int i=0;
        int j=a[0].length-1;
        while (i!=a.length&&j!=-1) {
            if (a[i][j]==x) return true;
            else if (x<a[i][j]) {
                j--;
            } else //x>a[i][j])
            {
                i++;
            }
        }
        return false;
    }
}

package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by henry on 8/28/2014.
 */
public class UtopianTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T_ = br.readLine();
        int T = Integer.parseInt(T_);

        int treeHeight = 1;

        for (int i=0; i<T; i++) {
            treeHeight = 1;
            String cycles_ = br.readLine();
            int cycles = Integer.parseInt(cycles_);
            while (cycles>0) {
                treeHeight = treeHeight*2;
                cycles--;
                if (cycles==0) break;
                treeHeight += 1;
                cycles--;
            }
            System.out.println(treeHeight);
        }

//        if (T == null || T.length() == 0) {
//            System.out.println("no string was inputed, try again!");
//            return;
//        }
    }
}

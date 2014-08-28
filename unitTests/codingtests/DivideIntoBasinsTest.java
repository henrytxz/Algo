package codingtests;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class DivideIntoBasinsTest {

    @Test
    public void testCountBasins3() throws Exception {
        String fileName = "resources/elevations3by3.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int dimension;
        String line = br.readLine();
        if (line!=null) {
            dimension = Integer.parseInt(line);
        } else {
            throw new IllegalArgumentException("no dimension found in file:"+fileName);
        }

        DivideIntoBasins s = new DivideIntoBasins(dimension);
        List<Integer> result = s.countBasins(br);
        for (int size : result) {
            System.out.print(size + " ");
        }
        System.out.println();
    }

    @Test
    public void testCountBasins5() throws Exception {
        String fileName = "resources/elevations5by5";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int dimension;
        String line = br.readLine();
        if (line!=null) {
            dimension = Integer.parseInt(line);
        } else {
            throw new IllegalArgumentException("no dimension found in file:"+fileName);
        }

        DivideIntoBasins s = new DivideIntoBasins(dimension);
        List<Integer> result = s.countBasins(br);
        for (int size : result) {
            System.out.print(size + " ");
        }
    }
}
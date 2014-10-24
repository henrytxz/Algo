package coreJava;

import interviews.Boggle;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by henry on 10/22/2014.
 */
public class SetTest {
    @Test
    public void test() {
        Boggle.Position p1 = new Boggle.Position(0,0);
        Set<Boggle.Position> set = new HashSet<Boggle.Position>();
        set.add(p1);
        Assert.assertTrue(set.contains(p1));

        Boggle.Position p2 = new Boggle.Position(0,0);
        Assert.assertTrue(set.contains(p2));
    }
}

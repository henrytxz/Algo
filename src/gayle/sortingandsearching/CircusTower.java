package gayle.sortingandsearching;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by henry on 9/30/2014.
 * question 11.7 on p122
 */
public class CircusTower {
    public static ArrayList<Htwt> getIncreasingSequence(ArrayList<Htwt> items) {
        Collections.sort(items);
        return longestIncreasingSubsequence(items);
    }

    private static void longestIncreasingSubsequence(ArrayList<Htwt> a, ArrayList<Htwt>[] solutions, int current_index) {
        if (current_index >= a.size() || current_index < 0) return;
        Htwt current_element = a.get(current_index);

        //find longest sequence we can append current_element to
        ArrayList<Htwt> best_sequence = null;
        for (int i=0; i<current_index; i++) {
            if (a.get(i).isBefore(current_element)) {
                best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
            }
        }

        //append current element
        ArrayList<Htwt> new_solution = new ArrayList<Htwt>();
        if (best_sequence!=null) {
            new_solution.addAll(best_sequence);
        }
        new_solution.add(current_element);

        //add to list and recurse
        solutions[current_index] = new_solution;
        longestIncreasingSubsequence(a, solutions, current_index+1);
    }

    private static ArrayList<Htwt> longestIncreasingSubsequence(ArrayList<Htwt> a)  //suppose I call this with 1,9  2,14  3,10  4,11  5,12
    {
        ArrayList<Htwt>[] solutions = new ArrayList[a.size()];
        longestIncreasingSubsequence(a, solutions, 0);

        ArrayList<Htwt> best_sequence = null;
        for (int i=0; i<a.size(); i++) {
            best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
        }

        return best_sequence;
    }

    private static ArrayList<Htwt> seqWithMaxLength(ArrayList<Htwt> seq1, ArrayList<Htwt> seq2) {
        if (seq1==null) return seq2;
        if (seq2==null) return seq1;
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }
}

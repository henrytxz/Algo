package mockinterviews;

import java.util.*;

/**
 * Created by henry on 9/7/2014.
 */
public class DieHard {

    public static void main(String[] args) {
        //...

//        DieHard dh = new DieHard(4, new int[]{3,5});
        DieHard dh = new DieHard(4, new int[]{1});
        System.out.println(dh.getGoodPaths().get(0));
    }

    private int[] cupSizes;
    //private int[] state;
    private Map<State, Boolean> oldStates;
//    private Map<State, Stack<State>> paths;
    private List<Stack<State>> goodPaths;
    private State doneState;

    public List<Stack<State>> getGoodPaths() { return goodPaths; }

    public DieHard(int goal, int[] cupSizes) {
        this.cupSizes = cupSizes;
        //this.state = new int[cupSizes.length];
        oldStates = new HashMap<State, Boolean>();
        goodPaths = new LinkedList<Stack<State>>();

        doneState = figureOutDoneState(goal);
        Stack<State> path = new Stack<State>();
        path.push(doneState);
        recurse(doneState, path);
    }

    //todo: hard-coding for now
    private State figureOutDoneState(int goal) {
//        return new State(new int[]{3,1});
        return new State(new int[]{4});
    }


    private int[] fill(int[] state, int cup) {
        int[] result = state.clone();
        result[cup] = cupSizes[cup];
        return result;
    }

    private int[] empty(int[] state, int cup) {
        int[] result = state.clone();
        result[cup] = 0;
        return result;
    }

    /*
        could rename cup1 to "from" and cup2 to "to"
    */
    private int[] pour(int[] state, int cup1, int cup2) {
        int[] result = state.clone();
        int space = cupSizes[cup2]-result[cup2];
        if (result[cup1]>=space) {
            result[cup2]+=space;
            result[cup1]-=space;
        } else {
            result[cup2]+=result[cup1];
            result[cup1]=0;
        }
        return result;
    }

    private List<State> getPossibleStates(State fromState) {
        List<State> result = new LinkedList<State>();
        int[] a = fromState.get();
        for (int i=0; i<a.length; i++) {
            if (a[i]!=0) {
                State toState = new State(empty(a, i));
                if (isReversible(fromState, toState)) { result.add(toState);
//                    System.out.println("going from "+fromState.print()+" to "+toState.print());
                }
            }
            if (a[i]!=cupSizes[i]) {
                State toState = new State(fill(a, i));
                if (isReversible(fromState, toState)) { result.add(toState); }
            }
            for (int j=0; j<a.length&&j!=i; j++) {
                if (a[i]!=0&&a[j]!=cupSizes[i]) {
                    State toState = new State(pour(a,i,j));
                    if (isReversible(fromState, toState)) { result.add(toState); }
                }
            }
        }
        return result;
    }

    private boolean isReversible(State fromState, State toState) {
        return getPossibleStates(toState).contains(fromState);
    }

//    private class Move {
//        private State fromState;
//        private State toState;
//        private boolean isReversible(State fromState, State toState) {
//            return getPossibleStates(toState).contains(fromState);
//        }
//    }

    private class State {
        private int[] state;
//        private State done;

        private State(int[] state) {
            assert state.length == cupSizes.length;
            this.state = state;

//            int[] a = new int[cupSizes.length];
//            for (int i=0; i<a.length; i++) {
//                a[i] = 0;
//            }
//            done = new State(a);
        }
        private int[] get() { return state; }
//        private State getDoneState() {
//            return done;
//        }

        private boolean isGood() {
            for (int volume : state) {
                if (volume!=0) return false;
            }
            return true;
        }
        private String print() { return Arrays.toString(state); }
    }

    /*
        play with some ideas a little bit:
        the final state, suppose 3 cups size x, y, z
        is a, b, c s.t. a*x+b*y+c*z = goal
        and the state before, is probably when one of the cups is empty...
        so the state before is s.t. goal-state.totalVolume == x, y or z
    */
//    public Stack<State> try() {
//        //current state
//        int[] curr = new int[]{0,4};
//        State cState = new State(curr);
//        Stack<State> result = new Stack<State>();
//        result.push(cState);
//
//        //from a state, you can fill either cup, empty either cup or pour from one to another
//        recurse(cState);
//    }

    private void recurse(State s, Stack<State> path) {
        if (!oldStates.containsKey(s)) {
            if (s.isGood()) {
//                Stack<State> path = paths.get(s);
                path.push(doneState);
                goodPaths.add(path);
            }

            for (State i : getPossibleStates(s)) {
                oldStates.put(i, true);
                recurse(i, path);
            }
        }
    }
}

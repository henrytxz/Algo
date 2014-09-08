package mockinterviews;

import java.util.*;

/**
 * Created by henry on 9/7/2014.
 */
public class DieHard {

    private int[] cupSizes;

    private Map<State, Boolean> oldStates;
    private List<Stack<State>> goodPaths;
    private State doneState;

    public static void main(String[] args) {
        //...

//        DieHard dh = new DieHard(4, new int[]{3,5});
        DieHard dh = new DieHard(4, new int[]{1,5});
        System.out.println(dh.getGoodPaths());
    }

    public DieHard() {}

    public DieHard(int goal, int[] cupSizes) {
        this.cupSizes = cupSizes;
        oldStates = new HashMap<State, Boolean>();
        goodPaths = new LinkedList<Stack<State>>();

        doneState = figureOutDoneState(goal);
        Stack<State> path = new Stack<State>();
        recurse(doneState, path);
    }

    private void recurse(State s, Stack<State> path) {
//        System.out.println("recursing on "+s);
//        if (s.equals(new State(new int[]{0,0})))
//            System.out.println("pause");
        if (!oldStates.containsKey(s)) {
            oldStates.put(s, true);
            path.push(s);
            if (s.isGood()) {
                goodPaths.add((Stack<State>) path.clone());
                return;
            }

            List<State> possibleStates = getPossibleStates(s);
            for (State i : possibleStates) {
//                System.out.println("checking possible state "+i+" of state "+s);
                if (!oldStates.containsKey(i)&&isReversible(s, i)) {
//                    System.out.println("current state "+s);
                    recurse(i, path);
                }
            }
        }
    }

    protected List<State> getPossibleStates(State fromState) {
        List<State> result = new LinkedList<State>();
        int[] a = fromState.get();
        for (int i=0; i<a.length; i++) {
            if (a[i]!=0) {
                State toState = new State(empty(a, i));
                result.add(toState);
            }
            if (a[i]!=cupSizes[i]) {
                State toState = new State(fill(a, i));
                result.add(toState);
            }
//            if (i==0)
//                System.out.println("pause 1");
            for (int j=0; j<a.length; j++) {
                if (j==i) continue;
//                if (i==0&&j==1)
//                    System.out.println("pause 2");
                if (a[i]!=0&&a[j]!=cupSizes[j]) {
                    State toState = new State(pour(a,i,j));
                    result.add(toState);
                }
            }
        }
        return result;
    }




    //todo: hard-coding for now
    private State figureOutDoneState(int goal) {
//        return new State(new int[]{3,1});
        State hardCoding = new State(new int[]{0,2});
        assert hardCoding.get().length == cupSizes.length;
        return hardCoding;
    }

    public List<Stack<State>> getGoodPaths() {
        return goodPaths;
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

    protected boolean isReversible(State fromState, State toState) {
        List<State> possibleStates = getPossibleStates(toState);
        boolean reversable = possibleStates.contains(fromState);
        return reversable;
    }

//    private class Move {
//        private State fromState;
//        private State toState;
//        private boolean isReversible(State fromState, State toState) {
//            return getPossibleStates(toState).contains(fromState);
//        }
//    }

    protected State makeAState(int[] state) { return new State(state); }

    protected class State {
        private int[] state;

        private State(int[] state) {
            assert state.length == cupSizes.length;
            this.state = state;
        }
        private int[] get() { return state; }

        protected boolean isGood() {
            for (int volume : state) {
                if (volume!=0) return false;
            }
            return true;
        }
        public boolean equals(Object obj) {
            if (this == obj) return true;
            else if (!(obj instanceof State)) { return false; }
            else {
                State that = (State) obj;
                return Arrays.equals(state, that.get());
            }
        }
        public int hashCode() {
            int result = 0;
            for (int i=0; i<state.length; i++) {
                result += state[i]+Math.pow(7,i);
            }
            return result;
        }
        public String toString() { return Arrays.toString(state); }
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
}

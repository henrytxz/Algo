package gayle.treesandgraphs;

/**
 * Created by henry on 8/20/2014.
 * find the first common ancestor of two nodes in a binary tree
 * Avoid storing additional nodes in a data structure
 */
public class BinaryTreeCommonAncestor {
    public static Node find(Node n, int x, int y) {
        if (n == null) return n;
        Node lookL = find(n.left, x, y);
        Node lookR = find(n.right, x, y);
        if (lookL == null && lookR == null) {
            if (n.val == x) {
                n.found++;
                return n;
            } else if (n.val == y) {
                n.found++;
                return n;
            } else return null;
        }

        if (lookL != null) {
            if (lookL.found == 2) return lookL;
            else if (lookR != null)
                return n;
            else {
                n.found++;
                return lookL;
            }
        }

//        if (lookR != null) {
            if (lookR.found == 2) return lookR;
            else if (lookL != null) return n;
            else {
                n.found++;
                return lookR;
            }
//        }

    }
//        if (lookL!=null&&lookR!=null) {
//		/*
//		if (lookL.found==2) return lookL;
//		else if (lookR.found=2) return lookR;
//
//		no longer needed once well defined null
//		null means at least 1 value has been found
//		returning n because the above 2 cases are covered below
//		*/
//            n.found = 2;
//            return n; //relying on the assumption the Node values are unique
//        } else {	//one of lookL and lookR is not null
//            if (lookL!=null) {
//                if (lookL.found==2) return lookL;
//                else {
//                    n.found++;
//                    return n;
//                }
//            } else 	//lookR!=null
//            {
//                if (lookR.found==2) return lookR;
//                else {
//                    n.found++;
//                    return n;
//                }
//            }
//        }
}

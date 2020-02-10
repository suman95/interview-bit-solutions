/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

import java.util.*;

public class IntersectionOfArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int as = 0;
        int bs = 0;
        ArrayList<Integer> res = new ArrayList<>();
       while(as < A.size() && bs < B.size()) {
          // System.out.println(A.get(as) + " : " + B.get(bs) + " : " + (A.get(as).compareTo(B.get(bs)) == 0));
           if(A.get(as).compareTo(B.get(bs)) == 0) {
               res.add(A.get(as));
               as++;
               bs++;
           } else if(A.get(as) < B.get(bs)) {
               as++;
           } else {
               bs++;
           }
       }
       return res;
    }
}

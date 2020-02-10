/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

/*
Largest Rectangle in Histogram
https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 */

import java.util.ArrayList;
import java.util.Stack;

public class MaxHistogram {

    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<>();
        int tempArea, maxArea = -1, i = 0;
        int top;
        while(i < A.size()) {
            //System.out.println(s);
            if(s.isEmpty() || A.get(s.peek()) <= A.get(i)) {
                s.push(i++);
            } else {
                top = s.pop();
                tempArea = A.get(top) * ( s.isEmpty() ? i : (i - s.peek() - 1));
               // System.out.println(A);
                //System.out.println(tempArea);
                maxArea = maxArea > tempArea ? maxArea : tempArea;
            }
        }
        while (!s.isEmpty()) {
            top = s.pop();
            tempArea = A.get(top) * ( s.isEmpty() ? i : (i - s.peek() - 1));
            maxArea = maxArea > tempArea ? maxArea : tempArea;
        }
        return maxArea;
    }
}

/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

import java.util.Arrays;
import java.util.Stack;

public class ValidParenthesis {
    public int isValid(String A) {
        Stack<Character> s = new Stack<>();
        if(A.length() == 0) return 1;
        for(int i = 0 ; i < A.length(); i++) {
            if(Arrays.asList('{','[','(').contains(A.charAt(i))) {
                s.push(A.charAt(i));
            } else  {
                if(s.empty()) return 0;
                switch (A.charAt(i)) {
                    case '}': if(s.peek() == '{') s.pop(); else return 0; break;
                    case ')': if(s.peek() == '(') s.pop(); else return 0; break;
                    case ']': if(s.peek() == '[') s.pop(); else return 0; break;
                }
            }
        }
        return s.isEmpty() ? 1 : 0;
    }
}

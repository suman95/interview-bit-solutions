/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

import java.util.Stack;

/*
https://www.interviewbit.com/problems/simplify-directory-path/
Simplify Directory Path
 */
public class SimplyfiyDirectory {
    public String simplifyPath(String A) {
      //  if(A.compareTo("/") == 0) return "/";
        Stack<String> s = new Stack<>();
        String[] paths = A.split("/");
        for(int i = 0 ; i < paths.length; i++) {
            if(paths[i].length() != 0) {
                if (paths[i].compareTo(".") == 0) continue;
                else if (paths[i].compareTo("..") == 0){ if(!s.empty())s.pop(); }
                else s.push(paths[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!s.empty()) {
            res.insert(0,s.pop());
            res.insert(0,"/");
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}

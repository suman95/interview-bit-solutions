/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

public class LongestPrefix {
    public String longestCommonPrefix(String[] A) {
        int k = 0;
        StringBuilder res =  new StringBuilder();
        while(true) {
            if(A[0].length()-1 < k) {
                break;
            } else {
                char c = A[0].charAt(k);
                boolean flag = true;
                for (int i = 1; i < A.length; i++) {
                    if (A[i].length() > k) {
                        if (A[i].charAt(k) != c) {
                            flag = false;
                            break;
                        }
                    } else {
                        flag=false;
                        break;
                    }
                }
                if(!flag) return res.toString();
                res.append(c);
                k++;
            }
        }
        return res.toString();
    }
}

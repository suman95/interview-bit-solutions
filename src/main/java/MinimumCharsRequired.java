/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

public class MinimumCharsRequired {
    public int solve(String A) {
        boolean[] dp = new boolean[A.length()];
        dp[0] = true;
        int lastMid = 0;
        boolean even = false;
        for(int i = 1; i < A.length()-1; i++) {
            if(expand(i,i,A)) {
                lastMid = i;
            } else if(expand(i,i+1, A)){
                lastMid = i;
                even = true;
            }
        }
        int temp = 0;
        if(even) temp = A.length() - ((lastMid+1) * 2);
        else temp = A.length() - ((lastMid)*2) -1;
        return temp > 0 ? temp : 0;
    }

    public boolean expand(int start, int end, String A) {
        while (start >= 0 && end < A.length() && A.charAt(start) == A.charAt(end)) {
            start --;
            end ++;
        }
        if(start == -1) return true;
        else return false;
    }
}

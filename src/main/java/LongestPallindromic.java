/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPallindromic {
    public String longestPalindrome1(String A) {
        if(A == null || A.length() == 0) return "";
        if(A.length() == 1) return A;
        Boolean[][] dp = new Boolean[A.length()][A.length()];
        for(int i = 0 ; i < dp.length; i++) Arrays.fill(dp[i], false);
        for(int i = 0; i<A.length(); i++) {
            dp[i][i] = true;
        }
        //Util.print(dp);
        int start = 0;
        int end = 0;
        int len = 0;
        for(int i = 0 ; i < A.length()-1; i++) {
            if(A.charAt(i) == A.charAt(i+1)) {
                dp[i][i+1] = true;
                if(len < 2) {
                    len = 2;
                    start = i;
                    end = i+1;
                }
            }
        }
       // Util.print(dp);
        int te = 0;

        for(int i = 2; i < A.length(); i++) {
            for(int j = 0; j < A.length() - i; j++) {
                int k = j+i;
                dp[j][k] = A.charAt(j) == A.charAt(k) && dp[j+1][k-1];
                if(dp[j][k]) {
                    te = k-j+1;
                    if(len < te) {
                        len = te;
                        start = j;
                        end = k;
                    }
                }
            }
        }
        //Util.print(dp);
        return A.substring(start, end+1);
    }

    // Expand around method
    public String longestPalindrome(String A) {
        if(A == null || A.length() == 0) return "";
        if(A.length() == 1) return A;
        int max = 0;
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < A.length()-1; i++) {
            int len1 = expand(i,i,A);
            int len2 = expand(i,i+1,A);
            if(len1 >= len2) {
                if(max < len1) {
                    max = len1;
                    start = i - (len1/2);
                    end = i + (len1/2);
                }
            } else {
                if(max < len2) {
                    max = len2;
                    start = i - (len2/2)+1;
                    end = i+1 + (len2/2)-1;
                }
            }
        }
        return A.substring(start, end+1);
    }

    public int expand(int start, int end, String A) {
        int len = 0;
        while(start >= 0 && end < A.length() && A.charAt(start) == A.charAt(end)) {
            if(start == end) len+=1;
            else len+=2;
            start--;
            end++;
        }
        return len;
    }
}

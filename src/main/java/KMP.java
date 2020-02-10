/*
 *
 * Problem Link :
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

import java.util.Arrays;

public class KMP {

    public boolean isSubstring(String A, String pattern) {
        int[] pt = new int[pattern.length()];
        int j = 0;
        int i = 1;
        while (i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                pt[i] = pt[i-1] + 1;
                j++;
            } else {
                if(j != 0) {
                    j = pt[j-1];
                } else {
                    i++;
                }
            }
            //i++;
        }
        System.out.println(Arrays.toString(pt));
        return false;
    }
}

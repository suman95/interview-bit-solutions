/*
 *
 * Problem Link : https://www.interviewbit.com/problems/inorder-traversal/
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class InorderIterative {
    public int[] inorderTraversal(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<>();

        if (A != null) {
            Stack<TreeNode> s = new Stack<>();
            TreeNode curr = A;
            while (curr != null || !s.isEmpty()) {
                while (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
                curr = s.pop();
                arr.add(curr.val);
                curr = curr.right;
            }
        }
        int res[] = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}

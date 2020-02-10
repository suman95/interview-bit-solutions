/*
 *
 * Problem Link : https://www.interviewbit.com/problems/hotel-reviews/
 * Profile : http://suman95.github.io
 * Author : Suman Sahu
 * /
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Pair {
    int val;
    int i;
    Pair(int val, int i) {
        this.val = val;
        this.i = i;
    }
}

public class GoodReviewsTrie {

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    ;

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }


    public int[] solve(String A, String[] B) {
        String[] reviews = A.split("_");
        List<Pair> res = new ArrayList<>();
        root = new TrieNode();
        for(int i = 0; i < reviews.length; i++)
            insert(reviews[i]);
        for(int i =0 ; i < B.length; i++) {
            String[] temp = B[i].split("_");
            int val = 0;
            for(int j = 0; j < temp.length; j++) {
                val += search(temp[i]) ? 1 : 0;
            }
            res.add(new Pair(val,i));
        }
        res.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.val > o2.val) {
                    return 1;
                } else if(o1.val == o2.val) {
                    if(o1.i > o2.i) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        int[] result = new int[B.length];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).i;
        }
        return result;
    }
}

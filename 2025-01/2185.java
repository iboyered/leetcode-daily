// 2185 - Counting Words With a Given Prefix
// https://leetcode.com/problems/counting-words-with-a-given-prefix/
// January 9, 2025

class Solution {
    public int prefixCount(String[] words, String pref) {
        int wordsWithPrefix = 0;

        for (int i = 0; i < words.length; i++) {
            if (doesWordHavePrefix(words[i], pref)) {
                wordsWithPrefix++;
            }
        }

        return wordsWithPrefix;
    }

    private boolean doesWordHavePrefix(String word, String prefix) {
        if (word.length() < prefix.length()) {
            return false;
        }

        String wordPrefix = word.substring(0, prefix.length());
        if (wordPrefix.equals(prefix)) {
            return true;
        }

        return false;
    }
}

/**
 * Either this was the easiest one yet or I'm getting really good at this.
 * 
 * It's a very straightforward O(n) function.
 * Passed with a runtime that beats 100% of solutions (0ms).
 * 
 * It helps that the functionality for finding a prefix was available from yesterday's challenge.
 * I wonder what would be the best way to reduce memory usage?
 * I suppose I could reduce the number of variables used, but I'm going for easily readable code.
 */
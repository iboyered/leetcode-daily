// 3042 - Count Prefix and Suffix Pairs I
// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/
// January 8, 2025

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int totalPrefixAndSuffixPairs = 0;

        // check every string with every following
        for (int i = 0; i < words.length - 1; i++) {
            String shortWord = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String longWord = words[j];
                if(isPrefixAndSuffix(shortWord, longWord)) {
                    totalPrefixAndSuffixPairs++;
                }
            }
        }

        return totalPrefixAndSuffixPairs;
    }

    private boolean isPrefixAndSuffix(String shortWord, String longWord) {
        int shortLength = shortWord.length();
        int longLength = longWord.length();

        if (shortLength > longLength) {
            return false;
        } else if (shortWord.equals(longWord)) {
            return true;
        }

        String prefix = longWord.substring(0, shortLength);
        String suffix = longWord.substring(longLength - shortLength, longLength);
        // System.out.println(String.format("short is %s, long is %s, prefix is %s, suffix is %s", shortWord, longWord, prefix, suffix));
        if (shortWord.equals(prefix) && shortWord.equals(suffix)) {
            return true;
        }
        return false;
    }
}

/**
 * This succeeds and passes with a memory usage that beats 33.46% of solutions.
 * 
 * It's brute force, but it is clean and easy to parse.
 */
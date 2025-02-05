// 1790 - Check if One String Swap Can Make Strings Equal
// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
// February 4, 2025

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // base case, strings ARE equal
        if (s1.equals(s2)) { return true; }

        // There are two conditions for a single string swap to be possible:
        // 1. all letters in s1 must match all letters in s2
        // 2. there must be exactly 2 letters that differ in each
        boolean doAllLettersMatch = false;
        boolean areExactlyTwoLettersDifferent = false;

        int[] s1Letters = new int[26];
        int[] s2Letters = new int[26];

        int numberOfLettersThatDiffer = 0;

        // Loop through both strings
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // Track what letters show up in each string
            s1Letters[c1 - 'a' + 0] = s1Letters[c1 - 'a' + 0] + 1;
            s2Letters[c2 - 'a' + 0] = s2Letters[c2 - 'a' + 0] + 1;
            
            if (!(c1 == c2)) {
                numberOfLettersThatDiffer++;
            }
        }

        // Did the same letters show up?
        if (Arrays.equals(s1Letters, s2Letters)) {
            doAllLettersMatch = true;
        }

        // Did exactly two letters differ?
        if (numberOfLettersThatDiffer == 2) {
            areExactlyTwoLettersDifferent = true;
        }

        // If both are true, we can perform one string swap for equality.
        return (doAllLettersMatch && areExactlyTwoLettersDifferent);
    }
}

/**
 * This submission works, and beats 52% of submissions for runtime.
 * 
 * It's not the most elegant in terms of memory usage- it's more written
 * to understand the problem, then work through it.
 * 
 * After reading through the editorial, it looks like there is a simpler
 * solution to track whether enough letters match- given that only two
 * positions can differ, we can check what letters differ at the first position,
 * then if the same letters appear at the second difference,
 * the result is TRUE. So instead of using an array to track every letter,
 * we can use one variable for each differing letter.
 */
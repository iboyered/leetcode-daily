// 2657 - Find the Prefix Common Array of Two Arrays
// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
// January 13, 2025

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int arraySize = A.length;
        int[] prefixCommonArray = new int[arraySize];
        int totalCommonalities = 0;

        // commonalitySet stores integers we have encountered
        Set<Integer> commonalitySet = new HashSet<>();

        for (int i = 0; i < arraySize; i++) {
            totalCommonalities += checkCommonality(commonalitySet, A[i]);
            totalCommonalities += checkCommonality(commonalitySet, B[i]);

            // Set the index of our commonality array to the rolling total
            prefixCommonArray[i] = totalCommonalities;
        }

        // Return the commonality array
        return prefixCommonArray;        
    }

    // If we've encountered an int already, remove it and return 1. Otherwise, add it.
    private int checkCommonality(Set<Integer> commonalitySet, int checkInt) {
        if (commonalitySet.remove(checkInt)) {
            return 1;
        } else {
            commonalitySet.add(checkInt);
        }
        return 0;
    }
}

/**
 * This solutions passes! Runtime beats 72.92% and Memory beats 76.30%
 * 
 * I'm really proud of this one! Realized the solution relatively quickly,
 * and coming up with an O(n) algorithm to a Medium difficulty puzzle was satisfying.
 * 
 * I was also able to split checkCommonality out into its own function.
 * If I were to improve this, I could probably make the variable and function naming a bit more accurate.
 */
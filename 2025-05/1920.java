// 1920 - Build Array from Permutation
// https://leetcode.com/problems/build-array-from-permutation/
// May 5, 2025

class Solution {
    public int[] buildArray(int[] nums) {
        int numsLength = nums.length;
        int[] permutedNums = new int[numsLength];

        for (int i = 0; i < numsLength; i++) {
            permutedNums[i] = nums[nums[i]];
        }

        return permutedNums;
    }
}

/**
 * Easy problem to ease back into regular coding challenges.
 * O(n) runtime.
 * Runtime beats 98.72% of answers.
 */
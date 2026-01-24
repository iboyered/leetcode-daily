// 1877 - Minimize Maximum Pair Sum in Array
// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
// January 22, 2026

/**
 * A couple of steps needed for this one.
 * 1. Optimally pair up the elements
 * 2. Find the maximum minimum pair sum.
 *
 * To pair up the elements optimally, sort lowest to highest.
 * Then pair up each element with the opposite end of the array.
 * Check all sums and pick the min when we're halfway through.
 */

class Solution {
    public int minPairSum(int[] nums) {
        // First, sort nums
        Arrays.sort(nums);

        // Set up our variables
        int numsLength = nums.length;
        int currentMinMax = 0;

        // Then, iterate 
        for (int i = 0; i < numsLength/2; i++) {
            int currentPairSum = nums[i] + nums[numsLength-i-1];
            if (currentPairSum > currentMinMax) {
                currentMinMax = currentPairSum;
            }
        }

        return currentMinMax;
    }
}

/**
 * This solution came together quickly. Runtime beats 63.10% of Java submissions.
 * I'm surprised this was a Medium difficulty-
 * either I'm getting better at solving these, or the difficulty was mis-rated.
 * 
 * It seems the snag is understanding that optimal pairing is achieved
 * by sorting the array and pairing the lowest and highest values together.
 * 
 * Once that was complete, the rest was straightforward.
 */
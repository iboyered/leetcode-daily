// 1752 - Check if Array Is Sorted and Rotated
// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
// May 23, 2026

class Solution {
    public boolean check(int[] nums) {
        // Base case, only 1 num in array
        if (nums.length == 1) return true;

        // Check if we've rotated and track the min of the left side
        boolean arrayWasRotated = false;
        int leftSideMin = nums[0];

        // Store the previous element
        int lastNum = nums[0];

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];

            // If we reach a potential rotation point
            if (currentNum < lastNum) {

                // If we already rotated, we're done
                if (arrayWasRotated) return false;

                // If we haven't rotated yet, track this rotation
                arrayWasRotated = true;
            }

            // If we already rotated, make sure we're not within the left side
            if (arrayWasRotated) {
                if (currentNum > leftSideMin) return false;
            }

            // Prepare the next iteration
            lastNum = currentNum;
        }

        // We've reached the end, so array is sorted, rotated, or both.
        return true;
    }
}

/**
 * Accepted and runtime of 0ms beats 100% of submissions,
 * memory usage of 42.90mb beats 79.50% of submissions.
 * 
 * This one took me some work and iteration to refine the condition matching.
 * It makes 1 pass through the array, comparing each value with the previous
 * to see if certain conditions have been met:
 * 
 * 1. Has the array been rotated?
 *  - If it was rotated once before, it can't be rotated twice, so return false.
 * 2. If we rotated, are we within the left side of the array?
 *  - If so, this isn't a valid sorted rotation, so return false.
 * 
 * This is basically the same as "Approach 3: Find Smallest Element"
 * from the Editorial. O(n) time and O(1) space.
 */
// 33 - Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/
// May 22, 2026

class Solution {
    public int search(int[] nums, int target) {
        // Brute force algorithm:
        // - Iterate through all values of nums
        // - If nums[i]<lastNum set rotated=true
        // - If nums[i]==target return i
        // - If nums[i]>target and rotated==true return -1
        int lastNum = nums[0];

        // Base case the first num is the target
        if (lastNum == target) return 0;

        // Base case the first num is the only num and not the target
        if (nums.length == 1) return -1;

        boolean wasRotated = false;

        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];

            if (currentNum == target) return i;
            if (currentNum < lastNum) wasRotated = true;
            if (currentNum > target && wasRotated) return -1;

            lastNum = currentNum;
        }

        return -1;
    }
}

/**
 * Accepted and runtime of 0ms beats 100% of submissions!
 * 
 * The problem required an algorithm of runtime O(log(n)).
 * 
 * I figured the most straightforward approach would be to iterate through nums,
 * with some checks along the way in case we found our target early.
 * 
 * Check 0: Is the target the current num?
 * Implementation: if (currentNum == target) return i;
 * Purpose: This is our goal, so return the current index.
 * 
 * Check 1: Has the array been rotated, and did we reach the rotation point?
 * Implementation: if (currentNum < lastNum) wasRotated = true;
 * Purpose: If we've reached the rotation point, we know we've seen our highest int value.
 * 
 * Check 2: If the array was rotated, did we pass our target?
 * Implementation: if (currentNum > target && wasRotated) return -1;
 * Purpose: After rotation, if we've passed our target, it doesn't exist.
 * 
 * ===
 * 
 * After investigating the Solutions & Submissions, I see there is a more elegant approach:
 * 1. Find the rotation point using a left-bound binary search
 * 2. Perform an exact binary search using the rotation point
 *  to map the "unrotated" nums onto their real rotated indecies
 * 
 * This approach requires 2 binary searches with some additional conditions.
 * 
 * I will read up on Binary Searches to learn more!
 */
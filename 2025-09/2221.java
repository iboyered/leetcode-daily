// 2221. Find Triangular Sum of an Array
// https://leetcode.com/problems/find-triangular-sum-of-an-array/
// September 29, 2025

class Solution {
    public int triangularSum(int[] nums) {
        // Second attempt- perform the calculation in place on the nums array.
        int numsLength = nums.length;

        // Base case- only one number, so return it
        if (numsLength == 1) {
            return nums[0];
        }

        // Iterate from large size to small
        for (int i = numsLength; i > 1; i--) {
            nums = calculateNextRow(nums, i-1);
        }

        return nums[0];
    }

    // Given an array of nums, perform the calculation for the next row of triangular sum
    private int[] calculateNextRow(int[] nums, int elementsToCalculate) {
        int a = nums[0];
        int b = nums[1];

        // Iterate over the next row and calculate the values
        for (int i = 0; i < elementsToCalculate; i++) {
            nums[i] = moduloAddition(a, b);
            a = b;

            // Prevent b from accessing beyond the end of nums. Slower but safer.
            if (!(i+2 > elementsToCalculate)) {
                b = nums[i+2];
            }
        }

        return nums;
    }

    // Perform the modulo addition. Add A and B and subtract 10 if it's over 10.
    private int moduloAddition(int a, int b) {
        return (a + b) % 10;
    }
}

/**
 * This second attempt at the solution was much more efficient than the first,
 * both in terms of runtime and memory usage.
 * Runtime of 41ms beats 93.32%, and Memory beats 98.11%.
 * 
 * Instead of creating a new array for each row, I simply reused the nums array,
 * calculating the next row in place. This saved both time and memory.
 * 
 * I am sure there is some fancy math that could be done to calculate the result
 * on a single iteration through the nums array, but that is beyond my knowledge.
 * 
 * After looking at the editorial, I see that there is a combinatorial math solution
 * that can calculate the result in a single pass. I will have to study up on
 * combinatorics to understand that one!
 */

// Below is my first attempt: a basic implementation that works by brute force.
// Runtime beats 46.54% and memory beats 19.50%.
// I'm going to attempt using the same nums array to go faster.
// class Solution {
//     public int triangularSum(int[] nums) {
//         // Since we are basically given the algorithm, the challenge here is not calculating the sum, the challenge is memory and speed.
//         // Let's start with the most basic implementation, brute forcing the problem.
//         int numsLength = nums.length;

//         // Base case- only one number, so return it
//         if (numsLength == 1) {
//             return nums[0];
//         }

//         // Start with the first row
//         int[] oldNums = nums;

//         // Iterate from large size to small
//         for (int i = numsLength; i > 1; i--) {
//             // Create a new smaller array for the next row
//             int[] newNums = new int[i-1];

//             newNums = calculateNewNums(newNums, oldNums);

//             // Repeat with the next row
//             oldNums = newNums;
//         }

//         return oldNums[0];
//     }

//     // Given an array of oldNums, perform the calculation for the next row of triangular sum
//     private int[] calculateNewNums(int[] newNums, int[] oldNums) {
//         int numsLength = newNums.length;

//         // Iterate over the next row and calculate the values
//         for (int i = 0; i < numsLength; i++) {
//             newNums[i] = moduloAddition(oldNums[i], oldNums[i+1]);
//         }

//         return newNums;
//     }

//     // Perform the modulo addition. Add A and B and subtract 10 if it's over 10.
//     private int moduloAddition(int a, int b) {
//         return (a + b) % 10;
//     }
// }
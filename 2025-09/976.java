// 976. Largest Perimeter Triangle
// https://leetcode.com/problems/largest-perimeter-triangle/
// September 27, 2025

class Solution {
    public int largestPerimeter(int[] nums) {
        // In order to form a triangle, we must have 3 integers a, b < c
        // such that a + b > c
        
        // So we need an algorithm that finds the 3 largest integers that work

        // First, sort the nums in order
        Arrays.sort(nums);

        // Next, work to find the perimeter
        return findLargestPerimeter(nums);
    }
    
    /**
     * Iterate through all nums to find the largest valid perimeter
     */
    private int findLargestPerimeter(int[] nums) {
        int a, b, c;

        // Start at the end of the array and work backwards to max 3rd digit
        for (int i = (nums.length-1); i > 1; i--) {
            // Set C to the biggest value we can
            c = nums[i];
            b = nums[i-1];
            a = nums[i-2];

            // If the perimeter is valid, return it
            if (a + b > c) {
                return (a + b + c);
            }
        }

        return 0;
    }
}

/**
 * I had to look at the editorial for this one since I kept timing out.
 * This solution passes with runtime 7ms that best 99.49% of Java submissions.
 * 
 * So my algorithm was correct, but my implementation kept timing out.
 * I realized that we could sort the array and iterate backwards,
 * but there were a couple key points I didn't realize that helped me simplify my implementation:
 * 
 * 1. We don't need to check EVERY possible value of a and b for each c,
 *    because if a + b <= c, then any smaller values of a or b will also fail.
 * 
 * 2. If we find a valid triangle, we can immediately return the perimeter,
 *    because we started with the largest possible value of c, and any
 *    smaller value of c can only return a smaller perimeter.
 */
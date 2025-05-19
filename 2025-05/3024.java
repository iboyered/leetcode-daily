// 3024 - Type of Triangle
// https://leetcode.com/problems/type-of-triangle/
// May 18, 2025

class Solution {
    public String triangleType(int[] nums) {
        // A Triangle CANNOT be formed if the sum of the 2 shortest sides <= the longest side
        // So first we need to check if the triangle is valid

        // To make this easy, first we will sort ascending
        Arrays.sort(nums);

        // Base Case - Check if the triangle is valid
        if (!triangleIsValid(nums)) {
            return "none";
        }

        // Case 1 - Equilateral
        if (triangleIsEquilateral(nums)) {
            return "equilateral";
        }

        if (triangleIsIsosceles(nums)) {
            return "isosceles";
        }

        // At this point there is only one option left
        // No need to check, just return
        return "scalene";

    }

    // Checks if a triangle can be formed
    private boolean triangleIsValid(int[] sideLengths) {
        int sumOfShorterSides = sideLengths[0] + sideLengths[1];
        int longerSide = sideLengths[2];

        if (sumOfShorterSides > longerSide) {
            return true;
        } else {
            return false;
        }
    }

    // Checks if all sides are equal length
    private boolean triangleIsEquilateral(int[] sideLengths) {
        if (sideLengths[0] == sideLengths[1] && sideLengths[1] == sideLengths[2]) {
            return true;
        } else {
            return false;
        }
    }

    // Checks if exactly 2 sides are equal length
    private boolean triangleIsIsosceles(int[] sideLengths) {
        if (
            // The smaller two numbers are equal
            (sideLengths[0] == sideLengths[1] && sideLengths[1] != sideLengths[2]) ||
            // Or the larger two numbers are equal
            (sideLengths[0] != sideLengths[1] && sideLengths[1] == sideLengths[2])
        ) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * This solution works but is neither fast nor memory-efficient.
 * 
 * I went for readability on this one. Definitely could have used
 * fewer lines of code, but I like seeing everything written out
 * in a way that makes the code more understandable.
 */
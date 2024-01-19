// 931 - Minimum Falling Path Sum
// https://leetcode.com/problems/minimum-falling-path-sum/
// January 18, 2024

// 38/50 Test Cases Passed. Time limit exceeded due to brute force implementation
// Let's see what the accepted solutions are...

// The solution is to use a 2D matrix to store the result for each cell in the first row
// It also uses the same base case and recursive function as I did
// However, it ALSO uses memoization to avoid redundant calculations
// If the result for a particular cell is already calculated,
// It is returned directly from the memoized table

// Interesting. I was close, but needed to memoize

class Solution {
    private int minimum;

    public int minFallingPathSum(int[][] matrix) {
        // Start with brute force
        // Iterate through every column
        // If the minimum is less than before, use that
        // At the end, return minimum

        // Get size of n
        int n = matrix.length;

        // Base case n is 1, so return value
        if (n == 1) { return matrix[0][0]; }

        this.minimum = 10001; // 10,000 is the maximum
        int value = 0;
        int row = 0;
        
        // For each element in the first row,
        for (int i = 0; i < n; i++) {
            getNextValue(matrix, row, i, value, minimum, n);
        }

        return minimum;
    }

    // Helper function to recursively trawl the tree
    public void getNextValue(int[][] matrix, int row, int col, int currentValue, int minimum, int n) {
        // Take the current value and add it to the value
        currentValue += matrix[row][col];

        // If we are at the last row, check the minimum
        if (row == (n-1)) {
            getAndSetMinimum(currentValue);
        }
        if (row < (n-1)) {
            // Otherwise, call each path below
            // Check the left
            if (col > 0) {
                getNextValue(matrix, row + 1, col - 1, currentValue, minimum, n);
            }
            // Check the middle
            getNextValue(matrix, row + 1, col, currentValue, minimum, n);
            // Check the right
            if (col < (n-1)) {
                getNextValue(matrix, row + 1, col + 1, currentValue, minimum, n);
            }
        }
    }

    // Helper function to get and set minimum
    public void getAndSetMinimum(int currentValue) {
        if (this.minimum > currentValue) {
            this.minimum = currentValue;
        }
    }
}
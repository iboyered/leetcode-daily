// 1975 - Maximum Matrix Sum
// https://leetcode.com/problems/maximum-matrix-sum/
// January 5, 2026

/**
The solution to this appears to be relatively straightforward,
and should be solvable in O(n^2) time.

First assumption: If there is an ODD number of negative integers,
    then there will always be at least 1 ODD integer remaining.

Second assumption: If we can multiply adjacent elements by -1 as often as we want,
    then we will always be able to set the 1 ODD integer to the number closest to 0.

Given these assumptions, our algorithm becomes straightforward:
- Iterate over all values [i][j]
    - Add the positive value of [i][j] to currentSum
    - If [i][j] is negative, track whether we have an even or odd negative count
    - If [i][j] is closer to 0, set a new closestToZero

- Once finished, if we have an odd negative count, return currentSum - (closestToZero * 2)
    - else return currentSum
*/

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long currentSum = 0;
        int closestToZero = Math.abs(matrix[0][0]); // Start with the first element
        boolean oddNegatives = false;
        int n = matrix.length;

        // Iterate over all values [i][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currentNumber = matrix[i][j];

                // If negative, track negatives and set to positive
                if (currentNumber < 0) {
                    oddNegatives = !oddNegatives;
                    currentNumber = currentNumber * -1;
                }

                // Check if new minimum
                if (currentNumber < closestToZero) {
                    closestToZero = currentNumber;
                }

                // Add to sum (we can add int to long)
                currentSum = currentSum + currentNumber;
            }
        }

        System.out.println("CurrentSum is " + currentSum);
        System.out.println("closestToZero is " + closestToZero);
        System.out.println("oddNegatives is " + oddNegatives);

        // At the end, if negatives were odd, subtract the minimum instead of adding
        if (oddNegatives) {
            return currentSum - (closestToZero * 2);
        }

        // Otherwise, just return the sum of the matrix
        return currentSum;
    }
}

/**
 * Nearly got this one on the first try. My initial solution took the first value
 * of [0][0] as closestToZero without setting it to positive first, which caused
 * some test cases to "subtract" a negative number at the end instead of the true closestToZero.
 * 
 * After fixing that, this solution passes all test cases.
 * Memory of 65.28 MB beats 100% of java submissions.
 * 
 * I'm surprised this was a Medium difficulty problem. It felt very straightforward.
 */
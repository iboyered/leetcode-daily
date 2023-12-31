// 1155 - Number of Dice Rolls with Target Sum
// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// December 26, 2023

// Did not reach solution, but was close!

class Solution {
    private long m = 1000000007;
    private long targetsHit = 0;

    // Helper function to call recursively
    private void nextDiceAmount(int currentSum, int diceRemaining, int n, int k, int target) {
        // For each dice that we have, go through possible values of k, add to sum, and check if above target
        for (int faceValue = 0; faceValue < k; faceValue++) {
            currentSum += faceValue;

            // Only continue if we are not above the target value
            if (currentSum < target) {

                // Subtract 1 from remaining dice and recursively call again
                if(diceRemaining > 0) {
                    diceRemaining--;
                    nextDiceAmount(currentSum, diceRemaining, n, k, target);
                }
                // Otherwise, we are at the end; if the total is equal, add 1 to targetsHit and do not call again
                else {
                    if (currentSum == target) {
                        targetsHit++;
                    }
                    // Check modulo
                    if (targetsHit > m) {
                        targetsHit = targetsHit % m;
                    }
                }
            }
        }
    }

    public int numRollsToTarget(int n, int k, int target) {
        // Base case n=1, so only 1 way to achieve target
        if (n == 1) {
            return 1;
        }

         // Base case target > possible sum of dice, so no possible way to achieve target
        if (target > k*n) {
            return 0;
        }

        // What do we know about the structure of dice?
        // There are k^n possible ways to roll the dice
        // If we have 2 dice, our target can be as small as 2 and as large as k*2
        // If we have 3 dice, our target can be as small as 3 and as large as k*3

        // Looking for patterns in the dice...
        // if n=2 and k=2
        // There is 1 way to roll 2 (1,1), 2 ways to roll 3 [(1,2), (2,1)], and 1 way to roll 4 (2,2)
        // if n=2 and k=3
        // There is 1 way to roll 2 (1,1), 2 ways to roll 3 [(1,2), (2,1)], 3 ways to roll 4 [(1,3), (2,2), (3,1)], 2 ways to roll 5 [(2,3), (3,2)], and 1 way to roll 6 (3,3)
        // if n=2 and k=4
        // There is 1 way to roll 2 (1,1), 2 ways to roll 3 [(1,2), (2,1)], 3 ways to roll 4 [(1,3), (2,2), (3,1)], 4 ways to roll 5 [(1,4), (2,3), (3,2), (4,1)], 3 ways to roll 6 [(2,4), (3,3), (4,2)], 2 ways to roll 7 [(4,3), (3,4)], and 1 way to roll 8 (4,4)
        // So the tree ends up as:
        // 1 2 1
        // 1 2 3 2 1
        // 1 2 3 4 3 2 1

        // Trying to increase n...
        // if n=3 and k=2
        // There is 1 way to roll 3 (1,1,1), 3 ways to roll 4 [(1,1,2), (1,2,1), (2,1,1)], 2 ways to roll 5 [(1,2,2), (2,2,1)], and 1 way to roll 6 (2,2,2)
        // if n=4 and k=2
        // There is 1 way to roll 4 (1,1,1,1), 4 ways to roll 5 [(1,1,1,2), (1,1,2,1), (1,2,1,1), (2,1,1,1)], 6 ways to roll 6 [(1,1,2,2), (1,2,1,2), (2,1,1,2), (1,2,2,1), (2,1,2,1), (2,2,1,1)], 4 ways to roll 7 [(1,2,2,2), (2,1,2,2), (2,2,1,2), (1,1,1,2)], and 1 way to roll 8 (2,2,2,2)
        // So the tree ends up as:
        // 1 3 2 1
        // 1 4 6 4 1

        // Looking at the hint:
        // "Use dynamic programming. The states are how many dice are remaining, and what sum total you have rolled so far."
        // Taking a look at https://stackoverflow.blog/2022/01/31/the-complete-beginners-guide-to-dynamic-programming/ to understand

        // The brute force approach would be to take every dice and compare its possible values with the possible values of every other dice
        //      This would have a potential runtime of O(k^n). Not good

        // So what we can do dynamically is keep track of the running total and dice remaining
        int currentSum = 0;
        int diceRemaining = n;

        // Recursively call a function that totals up the dice until we are have no dice remaining
        nextDiceAmount(currentSum, diceRemaining, n, k, target);

        return (int)targetsHit;
    }

    // Ran code: Time Limit Exceeded
    // NOTE: At this point, out of time, so going to check Solutions for correct answer
    // It looks like it is possible to use dynamic programming with a 2D int array int[n+1][target+1]
    // Then the solution involves recursively calling a function that iterates through k and calls recursively:
    //      Once a solution is reached, store it in the 2D array
    //      If the solution is in the 2D array, just return that

    // So I was not too far off! I just needed a smarter way to store the results.
    // By using a 2D array, we are able to track computed results faster and sneak under the time limit.
}
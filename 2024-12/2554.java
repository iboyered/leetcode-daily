// 2554 - Maximum Number of Integers to Choose From a Range I
// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
// December 6, 2024

// This works! Runtime beats 61.81% of users and Memory beats 9.09%.
// Learned (or refreshed my memory) that a set is useful for sorting and removing duplicates.

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        // Brute Force Solution
        // We are aiming for the MOST integers that adds up to the amount closest to maxSum
        // To achieve this, we will start at 1 and work our way up,
        // check whether each integer is in banned,
        // and add it to our running total if not.
        int currentSum = 0;     // The running total of our current sum
        int nextSum = 0;        // The potential next sum
        int integerCount = 0;   // The current count of integers used

        // We can't assume that banned is sorted, so we will have to sort it first and remove duplicates
        // We can easily achieve this by converting it to a set. loops through 1 time - O(n)
        Set<Integer> bannedSet = new HashSet<Integer>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        // Loop through all integers starting at 1 up to and including n
        for (int i = 1; i <= n; i++) {
            // Only proceed if the integer is not banned
            if (!bannedSet.contains(i)) {
                // Check if adding it would surpass maxSum. If so, return current count
                nextSum = currentSum + i;
                if (nextSum > maxSum) return integerCount;
                // If it doesn't surpass maxSum, increment the count and continue
                currentSum = nextSum;
                integerCount++;
            }
        }

        // If we have looped through all integers up to N and we haven't surpassed maxSum, return
        return integerCount;
    }
}

// First Submission: 105/208 testcases passed. Looks like banned can have duplicates
// Refactored to use a Set for banned instead of a sorted array

// Second solution succeeded!
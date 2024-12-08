// 2054 - Two Best Non-Overlapping Events
// https://leetcode.com/problems/two-best-non-overlapping-events/
// December 8, 2024

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Two events, at most, that don't overlap, to maximize values
        // If end time is T, start time of 2nd event must be T+1
        // At most 10^5 events, and time can be up to 10^9

        // Brute Force: 2D array, [events.length][events.length]
        int eventCount = events.length;

        // Store the current maximum
        int currentMax = 0;
        int currentSum = 0;

        /** Commenting out array to try and avoid exceeding memory limit
        // Each row will be for each event
        // Each column will be for all other events
        // Each own event space will be its own value
        int[][] totals = new int[eventCount][eventCount];
        */

        // For each event, compare every other event
        for (int i = 0; i < eventCount; i++) {
            for (int j = 0; j < eventCount; j++) {

                /** Commenting out array to try and avoid exceeding memory limit
                // If it's been checked already, skip
                if (totals[j][i] != 0) continue;
                */

                // If it's itself, set to its own value
                if (i == j) {
                    currentSum = events[i][2];
                } else {
                    // If the times are compatible, add the values
                    currentSum = checkCompatible(events[i], events[j]);
                }

                // If greater than current max, update
                if (currentSum > currentMax) {
                    currentMax = currentSum;
                }
            }
        }

        // By the end, we will have compared every event with every other
        // and found the maximum time 
        return currentMax;
    }

    private int checkCompatible(int[] event1, int[] event2) {
        // if start time of 1 is after end time of 2
        // or start time of 2 is after end time of 1
        if ((event1[0] > event2[1]) || (event2[0] > event1[1])) {
            return (event1[2] + event2[2]);
        } else {
            return 0;
        }
    }

    // This first brute force passes the basic test cases! Submitting now...
    // Ah, we've exceeded the memory limit. 36/63 testcases passed.
    // I wonder if this could be done in a single array instead?
    // Or... do I even need an array?

    // So after commenting out the array, I've now exceeded the time limit. 40/63 testcases passed.
    // Will save this solution for now and come back to this problem later, but I have some ideas.
}
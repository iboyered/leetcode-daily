// 1732 - Find the Highest Altitude
// https://leetcode.com/problems/find-the-highest-altitude/
// June 26, 2026

class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int currentGain : gain) {
            currentAltitude += currentGain;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}

/**
 * Easy straightforward problem. O(n) time.
 * 
 * Time of 0ms beats 100% of submissions.
 * 
 * I was glad I thought of Math.max() instead of an if statement.
 * Functionally the same, but code is more understandable.
 */
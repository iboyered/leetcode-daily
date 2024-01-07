// 446 - Arithmetic Slices II - Subsequence
// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
// January 6, 2024

// This one was HARD. This solution did not work. Need to check other solutions
// Looks like Dynamic Programming is needed?
// So it uses a hashmap to store indecies of elements with the same value. I used the correct map, but wrong purpose
// And a 2D dynamic array. Interesting
// I DID have the time complexity of O(n^2) correct

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // To begin determining what makes an arithmetic sequence,
        // We must first determine how a computer would calculate an arithmetic sequence.
        // THE DIFFERENCE BETWEEN CONSECUTIVE ELEMENTS IS THE SAME
        // So this means x[2]-x[1] == x[1]-x[0]
        // Or x[n+1] - x[n] == x[n] - x[n-1]
        
        // So we can determine this in O(n^2) time
        // Create a map of key value pairs where the key is the difference and the value is a counter
        // Loop through the array
        // For every element
        // Subtract it from every element after it
        // Take the difference and add it to the key-value map
        // Once complete, check elements of the map where value is >= 3
        // Return the number of those elements

        // Base case fewer than 3 elements, no subsequence
        if (nums.length < 3) { return 0; }

        // Start with our map of <diff,count>
        Map<Integer,Integer> diffCounts = new HashMap<Integer,Integer>();

        // Loop through every element
        for (int i = 0; i < nums.length; i++) {
            // Loop through every element after it
            for (int j = i+1; j < nums.length; j++) {
                // Take the difference and add it to the map
                int diff = nums[j] - nums[i];
                diffCounts.merge(diff, 1, Integer::sum); // Thanks https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
            }
        }

        // At the end, loop through map and count values greater than 3
        int subsequences = 0;
        for (Integer count : diffCounts.values()) {
            if (count > 2) { subsequences++; }
        }
        return subsequences;
    }
}
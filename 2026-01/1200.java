// 1200 - Minimum Absolute Difference
// https://leetcode.com/problems/minimum-absolute-difference/
// January 25, 2026

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // First, sort array from lowest to highest
        Arrays.sort(arr);

        // Establish minimum distance as distance between first 2 elements
        int minimumDifference = arr[1] - arr[0];

        // Create list of pairs to return
        List<List<Integer>> minimumDifferencePairs = new LinkedList<List<Integer>>();

        // Next, iterate through the array
        for (int i = 0; i < (arr.length - 1); i++) {
            // Check difference between one element and the next
            int currentDifference = arr[i + 1] - arr[i];

            // Compare current difference with minimum
            if (currentDifference == minimumDifference) {
                // If the differences are the same, add the pair to the return list
                addIntegerPairToList(minimumDifferencePairs, arr[i], arr[i + 1]);
            } else if (currentDifference < minimumDifference) {
                // If the current difference is smaller, reset the list
                minimumDifferencePairs = new LinkedList<List<Integer>>();
                minimumDifference = currentDifference;
                addIntegerPairToList(minimumDifferencePairs, arr[i], arr[i + 1]);
            }
        }

        return minimumDifferencePairs;
    }

    /**
     * Helper function to add a pair of integers to a list
     */
    private void addIntegerPairToList(List<List<Integer>> minimumDifferencePairs, int firstInt, int secondInt) {
        List<Integer> integerPair = new LinkedList<Integer>();
        integerPair.add(firstInt);
        integerPair.add(secondInt);
        minimumDifferencePairs.add(integerPair);
    }
}

/**
 * Solution passes and runtime beats 97.68% of java submissions.
 * This one didn't take too long to figure out, which was nice.
 * 
 * My first implementation of this one works, but I ran into some compilation errors.
 * 
 * The big issue was figuring out how to nest the lists.
 * Since the return value expected was a list of integer lists, I had to make sure every
 * definition and usage of the list reflected that.
 */
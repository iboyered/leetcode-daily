// 2610 - Convert an Array Into a 2D Array With Conditions
// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
// January 2, 2024

// Completed!
// Runtime of 4ms beats 55.24% of users with Java

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // We want to create the smallest possible array
        // Number of rows will be the amount of times the most frequently appearing element is seen
        // Number of columns will be the amount of distinct elements
        int numRows = 0;
        int numCols = 0;

        // If this is using Lists, not Arrays, that makes my life easier actually
        // We can build this using ArrayLists

        // Create an array to track how many times each number was seen
        // The number's index is the number, and the value is how many occurrences we saw
        int[] numbersSeen = new int[nums.length + 1];
        Arrays.fill(numbersSeen, 0);

        // First, iterate through all elements in nums
        // If we see an element, keep track of it
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            // If the element hasn't been seen yet, add a column
            if (numbersSeen[currentNum] == 0) {
                numCols++;
            }
            // Increment the number of times seen
            numbersSeen[currentNum]++;
            // If this is the new most common number, add a row
            if (numbersSeen[currentNum] > numRows) {
                numRows++;
            }
        }

        // Create our list of lists
        List rows = new ArrayList<Integer>(numRows);
        while (rows.size() < numRows) {
            List column = new ArrayList<Integer>(numCols);
            rows.add(column);
        }

        // Next, iterate through the numbers seen and add them to rows
        for (int currentNum = 0; currentNum < numbersSeen.length; currentNum++) {
            int occurrences = numbersSeen[currentNum];
            // If the number was never seen, ignore it
            if (occurrences > 0) {
                // For every occurrence of the number
                // Add it to the next list in order
                for (int count = 0; count < occurrences; count++) {
                    List nextList = (ArrayList<Integer>)rows.get(count);
                    nextList.add(currentNum);
                }
            }
        }

        // Return the list of lists
        return rows;
    }
}
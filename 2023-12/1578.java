// 1578 - Minimum Time to Make Rope Colorful
// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
// December 27, 2023

// This works! Memory beats 83.75% of users with Java.

class Solution {

    // We will loop through Colors and store the previous color
    // If we encounter 2 consecutive identical colors in the string:
    // - Start tracking how many of the same color are in a row
    // - Store a max heap of all the neededTimes
    // - Sum the needed times
    // Once we have reached the end of consecutive colors:
    // - Pop the highest value from the heap
    // - Subtract that value from the sums
    // - Add that sum to total time

    public int minCost(String colors, int[] neededTime) {
        // variables needed
        int totalTime = 0;
        char[] colorArray = colors.toCharArray();
        char previousColor = 'A';

        // The main for loop
        for (int balloon = 0; balloon < colors.length(); balloon++) {
            // If the previous color matched, 
            if (previousColor != 'A' && previousColor == colorArray[balloon]) {
                // Use a helper function to find the needed time
                int[] neededTimeResult = findNeededTime(colorArray, neededTime, previousColor, balloon);
                totalTime += neededTimeResult[0];
                // If we had more than 1 balloon in a row, increase our iterator
                balloon = balloon + neededTimeResult[1];
            }
            // Once the magic is done, set the next color. But don't go out of bounds
            if (balloon < colors.length()) {
                previousColor = colorArray[balloon];
            }
        }

        return totalTime;
    }

    private int[] findNeededTime(char[] colorArray, int[] neededTime, char previousColor, int balloon) {
        int totalTime = 0;
        int balloonCount = 0;
        // Create our max heap of times
        PriorityQueue<Integer> maxTime = new PriorityQueue<>(Comparator.reverseOrder());

        // Start with the previous time
        totalTime += neededTime[balloon-1];
        maxTime.add(neededTime[balloon-1]);

        // Continue along the balloon string until the colors don't match or we reach the end
        while(previousColor == (colorArray[balloon]) && balloon < colorArray.length) {
            // Add the current time and go to the next balloon
            totalTime += neededTime[balloon];
            balloonCount++;
            maxTime.add(neededTime[balloon]);

            // Set the new previous color and increment balloon
            previousColor = colorArray[balloon];
            balloon++;
            if (balloon == colorArray.length){
                break;
            }
        }

        // Once we are done, get the top of the heap and subtract.
        // This is because the time it takes to remove all but the biggest matched balloon will be the sum of the rest.
        totalTime -= maxTime.peek();

        // Return both the total time taken and how many ballons were counted
        int[] result = {totalTime, balloonCount};
        return result;
    }
}
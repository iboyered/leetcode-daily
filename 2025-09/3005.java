// 3005. Count Elements With Maximum Frequency
// https://leetcode.com/problems/count-elements-with-maximum-frequency/
// September 22, 2025

class Solution {
    public int maxFrequencyElements(int[] nums) {
        // I'm sure there's an elegant solution for this
        // but first, just code a basic implementation

        // 1. Create a tracking array of 1-100
        int[] totals = new int[101];
        int maxFrequency = 0;
        int elementsWithMaxFrequency = 0;
        int currentFrequency;

        // 2. Loop through the nums array
        for (int number : nums) {
            currentFrequency = getAndStoreCurrentFrequency(number, totals);
            
            if (currentFrequency > maxFrequency) {
                // A. if we have a new highest frequency, increment max and reset
                maxFrequency++;
                elementsWithMaxFrequency = 1;
            } else if (currentFrequency == maxFrequency) {
                // B. If another number is at max, increment the count of elements at max
                elementsWithMaxFrequency++;
            }
        }

        // 3. Return the total count of elements with max frequency
        return elementsWithMaxFrequency * maxFrequency;
    }

    // Updates the tracking array and gets the current frequency of the number
    private int getAndStoreCurrentFrequency(int number, int[] totals) {
        int currentFrequency = totals[number] + 1;
        totals[number] = currentFrequency;
        
        return currentFrequency;
    }
}

/**
 * This solution passes, and with a runtime of 1ms, beats 99.44% of solutions.
 * 
 * It was a relatively straightforward solution, but I was proud
 * of being able to implement it with only one loop.
 * 
 * Instead of looping through the tracking array at the end to
 * count the elements with max frequency, I was able to keep a
 * running total of elements at max frequency as I went.
 * 
 * If I were to improve this, I would try to use a HashMap
 * instead of an array to track frequencies, to allow
 * for a more optimal use of memory.
 */
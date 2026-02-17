// 401 - Binary Watch
// https://leetcode.com/problems/binary-watch/
// February 16, 2026

/**
 * There are 10 LEDs. 4 hours, 6 minutes.
 *
 * Given this, we can define a function that
 * takes in an array of 10 TRUE or FALSE values
 * and returns the time, if it's valid.
 *
 * Then, for all int turnedOn, go through the array
 * and turn on each light one by one. If valid, append the string.
 */

class Solution {
    // List to contain all possible return times
    List<String> possibleTimes = new LinkedList<String>();

    public List<String> readBinaryWatch(int turnedOn) {
        // Base case. No times can be made
        if (turnedOn > 8) {
            return possibleTimes;
        }

        // Base case. 1 time can be made
        if (turnedOn == 0) {
            possibleTimes.add("0:00");
            return possibleTimes;
        }

        // First, recursively get arrays of lit LEDs
        int[] litLEDs = new int[10];
        Arrays.fill(litLEDs, 0);
        createLEDarray(litLEDs, 0, turnedOn);

        // Then, once all possible arrays have been checked, return the times
        return possibleTimes;
    }

    // We can get all possible arrays of lit LEDs with recursion
    private void createLEDarray(int[] litLEDs, int currentIndex, int lightsRemaining) {
        // For all potential remaining lights
        for (int i = currentIndex; i < 10; i++) {
            int[] currentlyLit = Arrays.copyOf(litLEDs, 10);

            // Light the light
            currentlyLit[i] = 1;

            if (lightsRemaining == 1) {
                // If this was the last light, check the time
                calculateTime(currentlyLit);
            } else {
                // If there are lights remaining, continue lighting
                createLEDarray(currentlyLit, i + 1, lightsRemaining - 1);
            }
        }
    }

    // Given an array of 10 LEDs, check what time is displayed
    private void calculateTime(int[] litLEDs) {
        // The first 4 values denote the hour
        int hour = litLEDs[0]*8 + litLEDs[1]*4 + litLEDs[2]*2 + litLEDs[3];

        // Check if hour is valid (NOTE - I assumed 12 was the max. 12 is actually not allowed)
        if (hour > 11) {
            return;
        }

        // The next 6 values denote the minute
        int minute = litLEDs[4]*32 + litLEDs[5]*16 + litLEDs[6]*8 + litLEDs[7]*4 + litLEDs[8]*2 + litLEDs[9];

        // Check if minute is valid
        if (minute > 59) {
            return;
        }

        possibleTimes.add(createTimeString(hour, minute));
    }

    // Take the hour and the minute and create a string of it
    private String createTimeString(int hour, int minute) {
        // Add a leading 0 to the minute if necessary
        String minuteString;
        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = "" + minute;
        }

        return (hour + ":" + minuteString);
    }
}

/**
 * Surprised how low the pass rate was for this Easy problem.
 * I really enjoy problems like this, where there's a real world application,
 * instead of an abstract series of numbers.
 * 
 * This solution passed, and a runtime of 6ms beat 60.33% of accepted Java submissions.
 * 
 * After checking the editorial, I'm realizing this could have been achieved
 * with bitwise operations, instead of mathematically calculating
 * the bit values myself.
 * 
 * Still, I'm pleased with the solution, and recursion was fun to practice.
 */
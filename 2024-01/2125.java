// 2125 - Number of Laser Beams in a Bank
// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
// January 3, 2024

// Successful!
// Runtime of 11ms beats 91.49% of users with Java
// I wonder if we could do better on memory if we calculated the result
// in the array itself, without using additional variables?

class Solution {
    // Helper function that determines the number of beams between rows A and B
    // Based on the number of devices in each row
    private int beamsBetweenRows(int deviceCountA, int deviceCountB) {
        // Base case no beams in a row
        if (deviceCountA == 0 || deviceCountB == 0) {
            return 0;
        }

        // Each node will share a connection with each node in the next row
        return deviceCountA * deviceCountB;
    }

    public int numberOfBeams(String[] bank) {
        // We can determine how many laser beams there are
        // By looping through the rows of the bank
        // Counting up the number of 1s in each row
        // And continuing to the next row that contains 1s
        // And calculating the number of beams between the two
        int devicesInPreviousRow = 0;
        int devicesInCurrentRow = 0;
        int totalBeams = 0;

        for (int i = 0; i < bank.length; i++) {
            char[] currentRow = bank[i].toCharArray();
            // Loop through the current row
            for (int j = 0; j < currentRow.length; j++) {
                // If we find a device, increment
                if (currentRow[j] == '1') {
                    devicesInCurrentRow++;
                }
            }

            // If we found a device in the current row,
            // Calculate beams with a helper function and add it to the total
            if (devicesInCurrentRow > 0) {
                totalBeams += beamsBetweenRows(devicesInPreviousRow, devicesInCurrentRow);

                // At the end, reset the device count to move to the next row
                devicesInPreviousRow = devicesInCurrentRow;
                devicesInCurrentRow = 0;
            }
        }

        return totalBeams;
    }
}
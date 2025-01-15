// 2429 - Minimize XOR
// https://leetcode.com/problems/minimize-xor/
// January 14, 2025

class Solution {
    public int minimizeXor(int num1, int num2) {
        String num2Binary = Integer.toBinaryString(num2);
        System.out.println("num2Binary is " + num2Binary);

        int setBits = 0;
        for (int i = 0; i < num2Binary.length(); i++) {
            if (num2Binary.charAt(i) == '1') {
                setBits++;
            }
        }
        System.out.println("Setbits is " + setBits);
        
        return calculateMinimalInt(num1, setBits);
    }

    /**
     * This is an extremely silly way of calculating the minimal int.
     * First, we will minimize the XOR by matching all bits, starting with the largest.
     * Add 1's in the positions where 1's are in num1, biggest to smallest.
     * If we still have bits to fill, go from smallest to biggest.
     * If we STILL have bits to fill, go up from there.
     * At the end, convert the bits to an int and return it.
     */
    private int calculateMinimalInt(int num1, int setBits) {
        // Determine where the highest bit will be
        String num1Binary = Integer.toBinaryString(num1);
        int num1BinarySize = num1Binary.length();

        int[] minimalIntArray = new int[num1BinarySize];

        System.out.println("num1Binary is " + num1Binary + " with a size of " + num1BinarySize);

        System.out.println("Matching from the largest");
        // Match bits starting with the largest (left to right)
        for (int i = 0; i < num1BinarySize; i++) {
            System.out.println("i is " + i + ", num1Binary[i] is " + num1Binary.charAt(i));
            if (num1Binary.charAt(i) == '1') {
                // If there are still bits to fill
                if (setBits > 0) {
                    System.out.println("Filling bit " + i + ", setBits is " + setBits);
                    // Add it in and shrink the bits to set
                    minimalIntArray[i] = 1;
                    setBits--;
                }
            }
        }

        if (setBits > 0) {
            System.out.println("Filling from smallest");
            // Fill bits starting with the smallest (right to left)
            for (int i = num1BinarySize-1; i >= 0; i--) {
                System.out.println("i is " + i + ", minimalIntArray[i] is " + minimalIntArray[i]);
                if (minimalIntArray[i] == 0) {
                    // If there are still bits to fill
                    if (setBits > 0) {
                        System.out.println("Filling bit " + i + ", setBits is " + setBits);
                        // Add it in and shrink the bits to set
                        minimalIntArray[i] = 1;
                        setBits--;
                    }
                }
            }
        }

        // Convert the int array to a string
        String minimalBitString = "";
        for (Integer intChar : minimalIntArray) {
            minimalBitString = minimalBitString + intChar;
        }

        // If there are STILL bits to fill, append more 1's to the start
        if (setBits > 0) {
            System.out.println("Appending additional bits");
            for (int i = 0; i < setBits; i++) {
                minimalBitString = "1" + minimalBitString;
            }
        }

        // Convert it to a string and return
        int minimalInt = Integer.parseInt(minimalBitString, 2);
        return minimalInt;
    }
}

/**
 * This passes, somehow.
 * Runtime beats 3.77% and Memory beats 5.66%.
 * 
 * It's an extremely goofy implementation and I'm not proud of it-
 * It generates the minimalInt by going bit by bit in num1 to ensure optimal placement of the 1's.
 * 
 * I am SURE there is a fancy use of a bitmask to calculate the answer,
 * but you know what? an answer that works is technically correct!
 */
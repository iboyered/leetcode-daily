// 1624 - Largest Substring Between Two Equal Characters
// https://leetcode.com/problems/largest-substring-between-two-equal-characters/
// December 31, 2023

// Successful - runtime of 2ms beats 56.36% of users with Java
// Probably could be refined further to use less memory
// But it's New Years Eve and I'm ready to celebrate

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // We can create an array of size 26 for each letter
        // Whenever we encounter a char, we can start tracking how long until the next char
        // Then we loop through the array and get the max

        // Base case string is length 1
        if (s.length() == 1) {
            return -1;
        }

        // === FIRST IMPLEMENTATION === (incorrect, misread the problem)
        
        /*
        char[] stringChars = s.toCharArray();
        int[] currentLengths = new int[256];
        Arrays.fill(currentLengths, -1);
        int[] substringLengths = new int[256];
        Arrays.fill(substringLengths, -1);

        // Loop through all characters in string
        for (int i=0; i < s.length(); i++) {
            char currentChar = stringChars[i];

            // If we've started tracking that char already, then check the length
            if(currentLengths[currentChar] != -1) {
                int substringLength = i-currentLengths[currentChar];

                // If the length is longer, set the new max length
                // Max length is distance between letters minus 1,
                // as that is the length of a substring between the two
                if (substringLength > substringLengths[currentChar]) {
                    substringLengths[currentChar] = substringLength - 1;
                }
            }

            // Track the new starting point of that character
            currentLengths[currentChar] = i;
        }

        // Now that we have our set of max substring lengths, take the highest
        int maxLength = -1;
        for (int length : substringLengths) {
            
            System.out.println(String.format("Current length is %d",length));
            if (length > maxLength) { maxLength = length; }
        }

        return maxLength;
        */

        // This initial solution passes 9/54 test cases
        // Fails on "mgntdygtxrvxjnwksqhxuxtrv"
        // OH, we want to just check the first and last viewing of each character.
        // I misread the problem as a new character resets the substring.
        // That actually makes this a bit easier

        // We can use 2 arrays to track the first and last viewing of each character
        // Then at the end, just check which is biggest

        // === SECOND IMPLEMENTATION === (correct)

        // Start by creating 2 arrays for first and last viewing
        char[] stringChars = s.toCharArray();
        int[] firstViewing = new int[256];
        Arrays.fill(firstViewing, -1);
        int[] lastViewing = new int[256];
        Arrays.fill(lastViewing, -1);

        // Loop through all characters in string
        for (int i=0; i < s.length(); i++) {
            char currentChar = stringChars[i];

            // If we haven't seen the character yet, track it
            if(firstViewing[currentChar] == -1) {
                firstViewing[currentChar] = i;
            } else {
                // If we have, set the latest instance
                lastViewing[currentChar] = i;
            }
        }

        // Then, loop through and get the largest distance
        int maxLength = -1;
        for (int i = 0; i < 256; i++) {
            int substringLength = lastViewing[i] - firstViewing[i] - 1;
            if (substringLength > maxLength) { maxLength = substringLength; }
        }

        return maxLength;
    }
}
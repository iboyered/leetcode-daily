// 3120 - Count the Number of Special Characters I
// https://leetcode.com/problems/count-the-number-of-special-characters-i/
// May 26, 2026

class Solution {
    public int numberOfSpecialChars(String word) {
        // Create maps to store which characters we've seen
        Set<Character> lowercaseLetters = new HashSet<>();
        Set<Character> uppercaseLetters = new HashSet<>();
        Set<Character> specialLetters = new HashSet<>();

        // Iterate through word
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            char lowercaseC = Character.toLowerCase(c);
            char uppercaseC = Character.toUpperCase(c);

            boolean isUpperCase = Character.isUpperCase(c);

            // If we've seen this special character, skip it
            if (!specialLetters.contains(lowercaseC)) {
                if (isUpperCase) {
                    // If we've seen it before as the opposite case
                    if (lowercaseLetters.contains(lowercaseC)) {
                        specialLetters.add(lowercaseC);
                    }
                    // Add it to its array
                    uppercaseLetters.add(c);
                } else {
                    // Same operations but if lowercase
                    if (uppercaseLetters.contains(uppercaseC)) {
                        specialLetters.add(lowercaseC);
                    }
                    lowercaseLetters.add(c);
                }
            }
        }

        return specialLetters.size();
    }
}

/**
 * Very inelegant and brute force. Checking editorial to see if there's
 * a more optimal solution
 * 
 * It looks like the editorial solution utilizes a single hashset for all characters,
 * then loops through all letters in the alphabet to check if both cases are present.
 * 
 * It looks like this problem has multiple potential implementations.
 * I'm content with the readability of mine- I'd probably just want to clean it up
 * a little bit before using it in production code. Additionally, I'd want to check
 * to make sure memory usage wouldn't be an issue with the multiple hashsets.
 */
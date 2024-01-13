// 1704 - Determine if String Halves Are Alike
// https://leetcode.com/problems/determine-if-string-halves-are-alike/
// January 11, 2024

// Solved. Learned how to define a set of Characters in Java

class Solution {
    public boolean halvesAreAlike(String s) {
        // Iterate through array
        // For half of array, if vowel, count up
        // For half of array, if vowel, count down
        // At end, if 0, return true, else false
        // Runtime is O(n)

        // Define vowels
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();

        // Keep count
        int count = 0;

        // Iterate through array
        for(int i = 0; i < chars.length/2; i++) {
            if (vowels.contains(chars[i])) { count++; }
        }
        for(int i = chars.length/2; i < chars.length; i++) {
            if (vowels.contains(chars[i])) { count--; }
        }

        if (count == 0) { return true; }
        return false;
    }
}
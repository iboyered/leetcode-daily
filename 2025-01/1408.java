// 1408 - String Matching in an Array
// https://leetcode.com/problems/string-matching-in-an-array/
// January 7, 2025

class Solution {
    public List<String> stringMatching(String[] words) {
        // use a hashset to avoid duplicates
        Set<String> substringWords = new HashSet();

        // compare every string to every other
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((i != j) && (words[i].contains(words[j]))) {
                    substringWords.add(words[j]);
                }
            }
        }

        // convert to correct return type
        List<String> finalWords = new ArrayList();
        finalWords.addAll(substringWords);
        return finalWords;
    }
}

/**
 * A very brute-force approach given words.length had a max value of 100.
 * 
 * This solution passed with a runtime that beat 43.69% of solutions.
 * 
 * Simply checks every word against every other.
 * If the word is not itself, and one word contains the other,
 * add the contained word to the result.
 * 
 * The result is stored in a Set to avoid duplicates.
 * 
 * To speed this up, if a substring is found, we could stop checking other words
 * since any other words that contain the substring wouldn't change the result.
 */
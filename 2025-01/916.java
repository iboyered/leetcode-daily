// 916 - Word Subsets
// https://leetcode.com/problems/word-subsets/
// January 10, 2025

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> universalWords = new LinkedList<>();

        for (int i = 0; i < words1.length; i++) {
            if(isUniversal(words1[i], words2)){
                universalWords.add(words1[i]);
            }
        }

        return universalWords;
    }

    private boolean isUniversal(String word, String[] chars) {
        String[] wordChars = word.split("");

        // loop through each subword in charsChars
        for (int i = 0; i < chars.length; i++) {
            String[] charsChars = chars[i].split("");

            List<String> wordCharsList = Arrays.asList(wordChars);
            ArrayList<String> wordCharsArrayList = new ArrayList<>();
            for (String wordChar : wordCharsList) {
                wordCharsArrayList.add(wordChar);
            }

            for (int j = 0; j < charsChars.length; j++) {
                ArrayList<String> newChars = wordCharsArrayList;
                String charToCheck = charsChars[j];
                if (newChars.contains(charToCheck)) {
                    newChars.remove(charToCheck);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * This is a woefully inefficient solution and does not pass.
 * It passes 43/56 test cases, then exceeds the time limit.
 * 
 * For every word in words1, it verifies whether all elements in words2 are subsets of words1
 * in a very roundabout manner.
 * 
 * If I had more time, I would refine this further, but unfortunately I'm out of time today
 */
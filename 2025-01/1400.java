// 1400 - Construct K Palindrome Strings
// https://leetcode.com/problems/construct-k-palindrome-strings/
// January 11, 2025

class Solution {
    public boolean canConstruct(String s, int k) {
        int stringLength = s.length();

        if (stringLength < k) {
            return false;
        }

        Set<Character> lettersWithOddOccurrences = new HashSet<>();

        for (int positionInString = 0; positionInString < stringLength; positionInString++) {
            char letter = s.charAt(positionInString);

            if (lettersWithOddOccurrences.contains(letter)) {
                lettersWithOddOccurrences.remove(letter);
            } else {
                lettersWithOddOccurrences.add(letter);
            }
        }

        int totalOddLetterCount = lettersWithOddOccurrences.size();

        if (totalOddLetterCount <= k && k <= stringLength) {
            return true;
        }
        return false;
    }
}

/**
 * This works! Memory beats 59.42% of submissions.
 * 
 * In order to determine the algorithm, I had to analyze how a palindrome is constructed with all letters.
 * I had to check what the maximum and minimum possible palindrome count could be.
 * 
 * Once that was determined, I could create the algorithm!
 * Initially, I used an array. The set was slower but used less memory. Two options!
 * 
 * Below, find the exploration I did before starting.
 */

/* ================================*/

/*
A little exploration of what a "palindrome" can be before we begin to create an algorithm
There doesn't need to be a letter in the middle, but it can be an individual letter on its own

Here, we need to use EVERY letter in the string to create the palindrome permutations
This way, we can get a sense of the rules of palindrome permutations using every letter

Let's take a look at "annabelle" and how often each letter appears:
a: 2
n: 2
b: 1
e: 2
l: 2

MAXIMUM number of palindromes: 9
MINIMUM number of palindromes: 1

Now let's look at "leetcode":
l: 1
e: 3
t: 1
c: 1
o: 1
d: 1

MAXIMUM number of palindromes: 8 (split e 3 times)
MINIMUM number of palindromes: 6

What insights do we get from this?
the MAXIMUM number of palindromes is always the number of letters
the MINIMUM number of palindromes is always the number of letters with odd counts

Therefore, the algorithm we can develop is:
- Create an array with every letter in the alphabet with values of '0'
- Loop through the string s
    - If letter was encountered 0 times, set it to 1
    - If letter was already 1, set it to 0
- Then, loop through the alphabet array
    - Sum of array elements is the MINIMUM
- Length of s is the MAXIMUM
- If k is inclusively within MINIMUM and MAXIMUM, return true, else false

A base case is if k is greater than the length of s, we know the result must be false

UPDATE after finding the solution: used a SET instead of ARRAY to track duplicates for memory usage
*/
// 166. Fraction to Recurring Decimal
// https://leetcode.com/problems/fraction-to-recurring-decimal/
// September 23, 2025

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // I'm not exactly sure if we're just doing long division here or what-
        // It CAN'T be as simple as just dividing and returning it.

        // Let's try long division to start.
        // Even if I'm wrong, coding long division will be a fun challenge.
        String fractionToReturn = "";
        int rollingNumerator;
        int numeratorIndex = 0;

        // 1. Start with the numerator inside.
        // We can split the numerator into a string we can get the character at.
        String numeratorDigits = getDigits(numerator);

        // Set up the rolling numerator
        rollingNumerator = incrementRollingNumerator(rollingNumerator, numeratorDigits[numeratorIndex]);
        numeratorIndex++;

        // 2. Loop through digits in the numerator
        while (rollingNumerator > 0) {

            // If we can divide the rolling numerator by the denominator and the result is > 1
            if (rollingNumerator / denominator > 1) {
                // Append the division result to the fractionToReturn
                
                // Subtract (denominator * division result) from rollingNumerator

            }

            // If we can't, then just continue down the numerator
            if(numeratorIndex > numeratorDigits.length()) {
                // If we're past the end of the numerator, just append 0
                rollingNumerator = incrementRollingNumerator(rollingNumerator, 0)
            } else {
                // Otherwise, get the next digit
                rollingNumerator = incrementRollingNumerator(rollingNumerator, numeratorDigits[numeratorIndex]);
            }
            numeratorIndex++;

            // Check for repeats- if we see the same string pattern 3 times, it's probably repeating
        }

        return fractionToReturn;
    }

    // Pulled from the internet
    private int[] getDigits(int number) {
        int[] digits = new int[String.valueOf(number).length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Character.getNumericValue(String.valueOf(number).charAt(i));
        }
    }

    private int incrementRollingNumerator(int rollingNumerator, int nextDigit) {
        return (rollingNumerator * 10) + nextDigit;
    }
}

/**
 * I didn't end up finishing this one, didn't have the time.
 * 
 * It was fun to try and implement long division programatically.
 * 
 * I'm not sure if it would have worked, especially for negative
 * integers, but it was a fun challenge. Going to accept that I
 * won't complete this in time and move on.
 */
// 1518. Water Bottles
// https://leetcode.com/problems/water-bottles/
// September 30, 2025

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Thinking through an algorithm to start:
        // 1. First, drink all water bottles
        // 2. Next, perform the exchange
        //  a. Do we have enough bottles to exchange? if not, end loop
        //  b. Exchange empty bottles and keep the remainder
        // 3. Return the number of bottles we drank
        int bottlesDrunk = 0;
        int fullBottles = numBottles;
        int extraBottles = 0;

        // Repeat this while there are still bottles to drink
        while(fullBottles > 0) {

            // Drink all water bottles
            bottlesDrunk += fullBottles;

            // We now have fullBottles + extraBottles of empty bottles
            extraBottles = fullBottles + extraBottles;

            // Exchange our empty bottles as many times as we can for full ones
            fullBottles = (extraBottles / numExchange);

            // Calculate how many bottles we did not fill
            extraBottles = extraBottles - (fullBottles * numExchange);
        }

        return bottlesDrunk;
    }
}

/**
 * Nice and easy. Runtime of 0ms beats 100%, but memory only beats 12.11%.
 * 
 * I liked how readable the solution ended up being.
 * 
 * Reading through the editorial, I see there is some fancy math that will
 * return a more optimized solution, but I am content with this one for today.
 */
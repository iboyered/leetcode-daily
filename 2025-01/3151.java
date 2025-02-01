// 3151 - Special Array I
// https://leetcode.com/problems/special-array-i/
// January 31, 2025

class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;

        int prevNum = 0;
        for (int num : nums) {
            if (prevNum != 0) {
                if (num % 2 == prevNum % 2) {
                    return false;
                }
            }
            prevNum = num;
        }

        return true;
    }
}

/**
 * This one took about 5 minutes total to read and write
 * Runtime beats 100% and memory beats 97%
 * 
 * Super easy, this one.
 */
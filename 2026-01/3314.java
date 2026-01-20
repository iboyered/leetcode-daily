// 3314 - Construct the Minimum Bitwise Array I
// https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/
// January 20, 2026

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = calculateMinBitwise(nums.get(i));
        }

        return ans;
    }

    private int calculateMinBitwise(int num) {
        for (int i = 0; i < 1000; i++) {
            if ((i | i + 1) == num) {
                return i;
            }
        }

        return -1;
    }
}

/**
 * Pretty straightforward. Simply iterate through the nums array
 * and compute the minimum bitwise value for each number.
 * 
 * This is the brute force implementation. The editorial suggests
 * using a bitwise operation approach, which uses O(nlog(m)) complexity.
 */
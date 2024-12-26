// 494 - Target Sum
// https://leetcode.com/problems/target-sum/
// December 26, 2024

class Solution {
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int validExpressionCount = 0;
        int rollingSum = 0;
        int index = 0;

        return recursivelyAddAndSubtractNums(rollingSum, index, validExpressionCount);
    }

    private int recursivelyAddAndSubtractNums(int rollingSum, int index, int validExpressionCount) {
        int sumWithAddedNum = rollingSum + this.nums[index];
        int sumWithSubtractedNum = rollingSum - this.nums[index];

        int nextIndex = index + 1;
        if(nextIndex == nums.length) {
            validExpressionCount += verifyFinalSum(sumWithAddedNum);
            validExpressionCount += verifyFinalSum(sumWithSubtractedNum);

            return validExpressionCount;
        }

        int nextAddedCount = recursivelyAddAndSubtractNums(sumWithAddedNum, nextIndex, validExpressionCount);
        int nextSubtractedCount = recursivelyAddAndSubtractNums(sumWithSubtractedNum, nextIndex, validExpressionCount);
        return nextAddedCount + nextSubtractedCount;
    }

    private int verifyFinalSum(int finalSum) {
        if (finalSum == this.target) {
            return 1;
        }
        return 0;
    }
}

/*
* After reading the book Clean Code by Uncle Bob,
* I'm trying to get better at writing self-documenting code
* and refactoring functions into smaller chunks that do just one thing.
* 
* This solution passed with memory usage that beats 80.94% of solutions.
* It recursively works through the nums by adding or subtracting each num
* and checking, if we are at the end, whether the total matches the target.
*/
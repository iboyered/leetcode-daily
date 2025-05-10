// 2918 - Minimum Equal Sum of Two Arrays After Replacing Zeros
// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/
// May 9, 2025

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long nums1IntegerSum = 0;
        long nums2IntegerSum = 0;

        int nums1ZeroCount = 0;
        int nums2ZeroCount = 0;

        // Loop through both arrays
        for (int number : nums1) {
            if (number == 0) {
                nums1ZeroCount++;
            } else {
                nums1IntegerSum += (long) number;
            }
        }

        for (int number: nums2) {
            if (number == 0) {
                nums2ZeroCount++;
            } else {
                nums2IntegerSum += (long) number;
            }
        }

        // Calculate the minimum and maximum
        long nums1Min = calculateMinimum(nums1IntegerSum, nums1ZeroCount);
        long nums2Min = calculateMinimum(nums2IntegerSum, nums2ZeroCount);

        long nums1Max = calculateMaximum(nums1IntegerSum, nums1ZeroCount);
        long nums2Max = calculateMaximum(nums2IntegerSum, nums2ZeroCount);

        return calculateMinSum(nums1Min, nums2Min, nums1Max, nums2Max);
    }

    // Helper function to calculate the minimum of a nums array
    private long calculateMinimum(long integerSum, int zeroCount) {
        return integerSum + (long) (zeroCount * 1);
    }

    // Helper function to calculate the maximum of a nums array
    private long calculateMaximum(long integerSum, long zeroCount) {
        if (zeroCount == 0) {
            return integerSum;
        } else {
            return Long.MAX_VALUE;
        }
    }

    // Helper functions to calculate the final return value
    private long calculateMinSum(long nums1Min, long nums2Min, long nums1Max, long nums2Max) {
        if (nums1Min > nums2Min) {
            return returnViableMinimum(nums1Min, nums2Max);
        } else {
            return returnViableMinimum(nums2Min, nums1Max);
        }
    }

    // A minimum is only viable if it falls within in the potential range of the other array.
    private long returnViableMinimum(long biggerMin, long smallerMax) {
        boolean isMinimumViable = (biggerMin <= smallerMax);
        if (isMinimumViable) {
            return biggerMin;
        } else {
            return (long) -1;
        }
    }
}

/**
Solution PASSES and runtime beats 88.73%!
I started out this one by writing ALL of the below reasoning
before ever writing a single line of code, and I think that
helped massively with understanding the problem before starting.

I purposefully coded my solution with more lines of code
than necessary in an attempt to make it as readable and understandable,
or as CLEAN, as possible. It can definitely still be refined,
but I think it's easy to follow.

=== Thought process for the solution begins below (Read the problem before reading this):

The MINIMUM number we can replace a 0 with is 1.

Therefore, for any array M,
the MINIMUM value is:
- The sum of all positive integers PLUS
- count[0]

We can always add large integers, but we CANNOT go under this minimum

If an array M has only positive integers, its value is FIXED.
The MAXIMUM value is:
- The sum of all positive integers
So the other array must have sum(ints) + count[0] < MAXIMUM(N)

If an array value is FIXED, it has a MAXIMUM limit

===

We can define a couple values as we go through our arrays:
// A rolling sum of all positive integers
nums1IntegerSum = 0;
nums2IntegerSum = 0;

// The amount of times we've encountered a zero
nums1ZeroCount = 0;
nums2ZeroCount = 0;

And once we've looped through the arrays, we can calculate a MIN and MAX for each

If the range for two arrays has no overlap, return -1
Else, return the higher MIN

Algorithm: Pick the higher MIN and check if the other MAX is equal or greater than it

===

All right, let's get coding

Update after coding: It passed first try!
Measured twice, cut once.
 */
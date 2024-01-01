// 455 - Assign Cookies
// https://leetcode.com/problems/assign-cookies/
// January 1, 2024

// Initially I was attempting to do this with max heap
// For some reason, it worked with all but one test case, which returned 71 instead of 70
// Then I looked at the editorial and realized you can sort arrays in place

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Given a set of cookies of various sizes
        // and a set of children of various greeds
        // We can assume that if we always assign the biggest cookie to the neediest kid possible,
        // Then the most possible children will be content

        // Base case no cookies
        if(s.length == 0) { return 0; }

        // Sort both arrays
        // so we can easily get biggest cookie and neediest kid
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;
        int cookieSize = 0;
        int neediness = 0;

        int cookieCount = 0;

        // Then, iterate over all children and attempt to give them a cookie
        while (cookieCount < s.length && contentChildren < g.length) {
            if (s[cookieCount] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieCount++;
        }

        return contentChildren;
    }
}
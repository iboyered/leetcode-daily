// 3160 - Find the Number of Distinct Colors Among the Balls
// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/
// February 6, 2025

class Solution {
    // Track which ball has what color
    Map<Integer, Integer> coloredBalls = new HashMap<>();

    // Track how many times each color has been used
    Map<Integer, Integer> timesEachColorAppears = new HashMap<>();

    public int[] queryResults(int limit, int[][] queries) {
        int querySize = queries.length;
        int[] distinctColorAtQuery = new int[querySize];

        // Loop through queries
        for (int i = 0; i < querySize; i++) {
            checkColor(queries[i]);
            distinctColorAtQuery[i] = timesEachColorAppears.size();
        }

        return distinctColorAtQuery;
    }

    // For each ball, check the color
    private void checkColor(int[] query) {
        int ball = query[0];
        int oldColor = 0;
        int newColor = query[1];
        boolean hasBallBeenColored = coloredBalls.containsKey(ball);

        if (hasBallBeenColored) {
            oldColor = coloredBalls.get(ball);
            if (oldColor == newColor) { return; }
            replaceColor(oldColor, newColor);
        } else {
            addNewColor(newColor);
        }
        coloredBalls.put(ball, newColor);
    }

    // Ball exists, but this is a new color
    private void replaceColor(int oldColor, int newColor) {
        addNewColor(newColor);
        subtractOldColor(oldColor);
    }

    // Add a new color
    private void addNewColor(int newColor) {
        Integer newColorFrequency = timesEachColorAppears.get(newColor);
        if (newColorFrequency == null) {
            timesEachColorAppears.put(newColor, 1);
        } else {
            timesEachColorAppears.put(newColor, newColorFrequency + 1);
        }
    }

    // Subtract an old color
    private void subtractOldColor(int oldColor) {
        int oldColorFrequency = timesEachColorAppears.get(oldColor);
        if (oldColorFrequency == 1) {
            timesEachColorAppears.remove(oldColor);
        } else {
            timesEachColorAppears.put(oldColor, oldColorFrequency - 1);
        }
    }
}

/**
 * This submission not only works, but memory beats 98.69% of all submissions!
 * 
 * I am EXTREMELY proud of this one! Probably the most challenging solve yet.
 * Using hash maps to track balls encountered and color frequency worked well.
 * 
 * The reusable functionality for adding a new color or reducing the frequency
 * of an old color made refactoring very practical.
 * 
 * This could probably be optimized for speed by reducing the amount of map operations
 * such as `containsKey`, so gets and contains can happen simultaneously,
 * but the important thing to me is the code remains readable.
 * 
 * I'm very happy with this one.
 */
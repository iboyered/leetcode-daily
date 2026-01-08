// 1339 - Maximum Product of Splitted Binary Tree
// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
// January 7, 2026

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /**
  * I don't think I know enough about binary trees to necessarily solve this elegantly.
  * Let's try the brute force approach.
  * 
  * To maximize the product of the sums of the subtrees,
  * both subtrees should be as equal as possible.
  *
  * My initial thought is to trawl all possible subtree combinations,
  * but with 50000 possible nodes, that seems extremely costly.
  *
  * Took a look at the hint- for each node, answer is max((total_sum - subtree_sum) * subtree_sum) at each node.
  * Knowing that is helpful, but I'm not sure programattically how we'd get that information
  *
  * What about this?
  * - Trawl the entire binary tree
  * - For each node, calculate its sum
  * - The total sum will be the sum of the root node
  * - Maximum will be whichever subtree sum is closest to (total_sum / 2)
  * - OR we can go through each subtree sum with the total sum, and calculate its local maximum
  *
  * This should work. So the setup:
  * - Create a HashSet of subtree_sums
  * - Recursively go through the binary tree
  *   - For each node, store its subtree_sum in the set subtree_sums
  *   - For the root node, store its subtree_sum as total_sum
  * - Iterate over all items in subtree_sums
  *   - For each sum, calculate the max with the forumla (total_sum - subtree_sum) * subtree_sum
  *   - Since we expect max to grow then shrink, if max is not greater, stop iterating and return current_max % 10^9 + 7
  */
class Solution {
    // Create global subtree_sums HashSet
    HashSet<Long> subtree_sums = new HashSet<>();

    public int maxProduct(TreeNode root) {
        long total_sum = getSubtreeSum(root);

        long maximumProduct = calculateMaximumProduct(total_sum);

        int maximumProductModulo = getModulo(maximumProduct);

        return maximumProductModulo;
    }

    // Returns the subtree sum of a node and adds it to the subtree_sums HashSet
    private long getSubtreeSum(TreeNode currentNode) {
        long leftValue;
        long rightValue;

        // Check sub nodes
        if (currentNode.left == null) {
            leftValue = 0;
        } else {
            leftValue = getSubtreeSum(currentNode.left);
        }
        if (currentNode.right == null) {
            rightValue = 0;
        } else {
            rightValue = getSubtreeSum(currentNode.right);
        }

        // Calculate sum, add to HashSet, and return
        long subtree_sum = leftValue + rightValue + currentNode.val;
        subtree_sums.add(subtree_sum);
        return subtree_sum;
    }

    // Iterate over all subtree_sums to get the maximum product
    private long calculateMaximumProduct(long total_sum) {
        long maximumProduct = 0;

        // Iterate through the hashset
        for (long subtree_sum : subtree_sums) {
            long currentProduct = ((total_sum - subtree_sum) * subtree_sum);

            // Set new maximum
            if (currentProduct > maximumProduct) {
                maximumProduct = currentProduct;
            }
        }

        return maximumProduct;
    }

    // Calculate the modulo at the end
    private int getModulo(long maximumProduct) {
        long moduloValue = 1000000007L;
        long moduloProduct = maximumProduct % moduloValue;
        return (int) moduloProduct;
    }
}

/**
 * IT WORKED! It's not great in terms of Runtime or Memory, but it passes all test cases.
 * Runtime beats 6.20% and Memory beats 5.04% of Java submissions.
 * 
 * It's been a while since I've worked with Binary Trees, so it was refreshing to know
 * I still remember how to get the local sum of a subtree recursively.
 * 
 * I needed the Hint provided to get me on the right track. Without that, I don't think
 * I would have figured out how to get the maximum at each node.
 * 
 * After taking a look at the top solution, I see they used a similar approach,
 * but updated each subtree_sum in place instead of creating a new HashSet.
 * This would have saved memory. Good to know for future binary tree problems!
 */
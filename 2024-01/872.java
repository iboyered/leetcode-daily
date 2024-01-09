// 872 - Leaf-Similar Trees
// https://leetcode.com/problems/leaf-similar-trees/
// January 9, 2024

// Solved! Runtime of 0ms beat 100% of users with Java
// I had to look up the function to get leaves of a binary tree,
// but I learned recursion is the best way to do that!

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
class Solution {
    // Recursive function to traverse the tree and add leaves to a list
    private void addNodeToList(TreeNode node, List<Integer> list) {
        // If we're at a leaf, add it to the list
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        // If there's anything below it, call function recursively
        if (node.left != null) { addNodeToList(node.left, list); }
        if (node.right != null) { addNodeToList(node.right, list); }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // In a leaf value sequence, we are only interested in terminal nodes
        // That means a node with no left or right value will be a leaf
        // We can go through leaves from left to right on both trees and compare the values
        // If they are equal, return true. If not, return false.

        // Start by creating our two lists to add leaves to in sequence
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Then, collect all leaves
        // What's the best way to do this?

        // The algorithm:
        // We can keep track of where we are on the tree by creating a list of treenodes
        // And keep track of which direction we just moved with a string
        // Start at root
        // If node to the left, move left. Add parent to list. Make left node new current node
        // If no node to the left, move right. Add parent to list. Make right node new current node
        // If neither left or right, we are at a leaf
        //      Add the leaf's value to the list
        //      Move back to the previous node on the list
        //      If we came from the left side, set the current.left to null
        //      If we came from the right side, move back up the 

        // Okay, never mind, just going to look up how to do this one
        // https://www.geeksforgeeks.org/print-leaf-nodes-left-right-binary-tree/#
        // Ah, ok. A recursive function. Much easier
        // Just trawls the tree recursively and checks all nodes from left to right
        // Function is defined as addNodeToList

        // Now we can call the function
        addNodeToList(root1, list1);
        addNodeToList(root2, list2);

        // Compare lists and return
        if (list1.equals(list2)) { return true; }
        return false;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// TC - O(n), SC - O(n)
class Solution {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        countGoodNodes(root, Integer.MIN_VALUE);

        return count;
    }

    private void countGoodNodes(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            count++;
            max = root.val;
        }
        countGoodNodes(root.left, max);
        countGoodNodes(root.right, max);
    }
}
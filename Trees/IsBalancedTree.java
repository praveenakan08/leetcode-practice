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
// TC - O(n), SC - O(1)
class Solution {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        height(root);
        return result;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int r = Math.abs(left - right);
        result = result && ((r == 0) || (r == 1));
        return 1 + Math.max(left, right);
    }
}
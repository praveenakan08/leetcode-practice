/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// TC - O(h), SC - O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (current.val > p.val && current.val > q.val) {
                current = current.left;
            } else if (current.val < p.val && current.val < q.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }
}
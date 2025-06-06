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
// TC - O(n), SC - O(1)
class Solution {
    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList();
        inorder(root);

        return result;
    }

    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

}
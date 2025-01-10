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
    private List<Integer> result;

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList();

        postorder(root);
        return result;    
    }

    private void postorder(TreeNode root) {
        if(root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        result.add(root.val);
    }
}
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
// TC - O(nlogn), SC - O(n)
class Solution {
    List<Integer> result;

    public int kthSmallest(TreeNode root, int k) {
        result = new ArrayList();
        dfs(root, k);

        Collections.sort(result);
        return result.get(k - 1);
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        dfs(root.left, k);
        dfs(root.right, k);
    }
}
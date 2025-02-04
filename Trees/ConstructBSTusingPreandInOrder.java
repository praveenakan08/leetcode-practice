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
    private int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return splitTree(preorder, 0, inorder.length - 1, inMap);
    }

    // 3, 9, 20, 15

    // l -> 0, r -> 4, mid -> 1
    private TreeNode splitTree(int[] preorder, int left, int right, Map<Integer, Integer> inMap) {
        if(left > right) {
            return null;
        }

        int rootVal = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inMap.get(rootVal);

        root.left = splitTree(preorder, left, mid - 1, inMap);
        root.right = splitTree(preorder, mid + 1, right, inMap);
        
        return root;
    }
}
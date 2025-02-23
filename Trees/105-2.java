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

    private int index = 0; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map) {
        if(start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        int mid = map.get(root.val); // index -- of root from inorder
        root.left = construct(preorder, inorder, start, mid - 1, map);
        root.right = construct(preorder, inorder, mid + 1, end, map);

        return root;
    }
}
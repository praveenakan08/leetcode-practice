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

    int rootIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
       // pre-order -- root - left - right 
       // post-order -- left - right - root 
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        } 

        return construct(preorder, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int start, int end, Map<Integer, Integer> map) {
        if(start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[rootIndex++]);
        if(start == end) {
            return root;
        }

        int mid = map.get(preorder[rootIndex]);
        root.left = construct(preorder, postorder, start, mid, map);
        root.right = construct(preorder, postorder, mid + 1, end - 1, map);
        
        return root;
    }
}
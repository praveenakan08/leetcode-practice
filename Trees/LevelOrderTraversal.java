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
    private List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
       result = new ArrayList();
       Queue<TreeNode> q = new LinkedList();
       q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> r = new ArrayList();
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(current != null) {
                    r.add(current.val);

                    if(current.left != null) {
                        q.offer(current.left);
                    }

                    if(current.right != null) {
                        q.offer(current.right);
                    }
                }
            }
            
            if(!r.isEmpty()) {
                result.add(r);
            }
        }

        return result;
    }
}
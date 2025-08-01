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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> levelList = new ArrayList();
            int levelLength = q.size();

            for(int i = 0; i < levelLength; i++) {
                TreeNode currentNode = q.peek();

                if(currentNode.left != null) {
                    q.offer(currentNode.left);
                }

                if(currentNode.right != null) {
                    q.offer(currentNode.right);
                }

                levelList.add(q.poll().val);
            } 

            result.add(levelList);
        }

        return result;
    }
}
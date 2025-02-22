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

// TC - O(n), SC - O(n)
class FindElements {

    private TreeNode root;

    public FindElements(TreeNode root) {  
        this.root = root;

        Queue<TreeNode> q = new LinkedList();
        root.val = 0;  
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode polled = q.poll();
            int rootVal = polled.val;

            if(polled.left != null) {
                TreeNode left = polled.left;
                left.val = 2 * rootVal + 1;

                q.add(left);
            } 

            if(polled.right != null) {
                TreeNode right = polled.right;
                right.val = 2 * rootVal + 2;

                q.add(right);
            } 
        }
    }
    
    public boolean find(int target) {
        return findInTree(root, target);
    }

    private boolean findInTree(TreeNode node, int target) {
        if(node == null) {
            return false;
        }

        if(node.val == target) {
            return true;
        }

        return findInTree(node.left, target) || findInTree(node.right, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
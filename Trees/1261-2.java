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
// TC - O(n), SC - O(n) -- for storing elements
class FindElements {
    private Set<Integer> set;

    public FindElements(TreeNode root) {  
        set = new HashSet();

        Queue<TreeNode> q = new LinkedList();
        root.val = 0;  
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode polled = q.poll();
            int rootVal = polled.val;

            set.add(rootVal);
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
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
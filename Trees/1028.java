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
class Solution {
    public TreeNode recoverFromPreorder(String t) {
        Stack<TreeNode> stack = new Stack();
        StringBuilder val = new StringBuilder();
        int i = 0, dash = 0;

        while(i < t.length()) {
            while(i < t.length() && t.charAt(i) == '-') {
                i++;
                dash++;
            }

            while(stack.size() > dash) {
                stack.pop();
            }

            while(i < t.length() && t.charAt(i) != '-') {
                val.append(t.charAt(i));
                i++;
            }

            TreeNode node = new TreeNode(Integer.parseInt(val.toString()));
            if(!stack.isEmpty()) {
                if(stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            stack.push(node);

            // cleanup
            val = new StringBuilder();
            dash = 0;
        }
        
        while(stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
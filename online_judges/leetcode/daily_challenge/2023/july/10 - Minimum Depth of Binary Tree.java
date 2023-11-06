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
    private static int ans;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        ans = Integer.MAX_VALUE;
        f(root, 1);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public void f(TreeNode root, int d) {
        if (root.left == null && root.right == null) {
            ans = Math.min(ans, d);
            return;
        }
        if (root.left != null) f(root.left, d+1);
        if (root.right != null) f(root.right, d+1);
    }
}
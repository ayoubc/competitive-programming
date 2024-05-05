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
    private int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        inorder(root, -1);
        return ans;
    }
    private void inorder(TreeNode tree, int lr) {
        if (tree == null) return;
        if (tree.left == null && tree.right == null && lr == 0) {
            ans += tree.val;
        }
        inorder(tree.left, 0);
        inorder(tree.right, 1);
    }
}
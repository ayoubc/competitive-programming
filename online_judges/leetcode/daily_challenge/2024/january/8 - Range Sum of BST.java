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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return solve(root, low, high);
    }
    public int solve(TreeNode root, int l, int r) {
        if (root == null) return 0;
        int res = 0;
        if (root.val >= l && root.val<=r) res += root.val;
        return res + solve(root.left, l, r) + solve(root.right, l, r);
    }
}
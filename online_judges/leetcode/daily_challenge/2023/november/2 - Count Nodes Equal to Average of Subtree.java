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
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        solve(root);
        return ans;
    }
    private int[] solve(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] res = {root.val, 1};
        int[] resL = solve(root.left);
        int[] resR = solve(root.right);

        res[0] += resL[0] + resR[0];
        res[1] += resL[1] + resR[1];
        if (root.val == res[0] / res[1]) ans ++;
        return res;
    }
}
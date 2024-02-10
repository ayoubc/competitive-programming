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
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root);
    }
    
    private int maxDiff(TreeNode root) {
        if (root == null) return 0;
        int[] res = findMaxMin(root);
        int res1 = Math.max(Math.abs(res[0]-root.val), Math.abs(res[1]-root.val));
        return Math.max(res1, Math.max(maxDiff(root.left), maxDiff(root.right)));
    }
    private int[] findMaxMin(TreeNode root) {
        if (root == null) return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] resL = findMaxMin(root.left);
        int[] resR = findMaxMin(root.right);
        return new int[] {Math.max(Math.max(resL[0], resR[0]), root.val), Math.min(Math.min(resL[1], resR[1]), root.val)};
    }
}
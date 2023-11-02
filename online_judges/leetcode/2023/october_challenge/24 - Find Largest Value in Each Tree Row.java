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
    private static List<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        travers(root, 0);
        return ans;
    }
    public void travers(TreeNode r, int level) {
        if (r == null) return;
        if (level == ans.size()) ans.add(r.val);
        else ans.set(level, Math.max(ans.get(level), r.val));
        travers(r.right, level+1);
        travers(r.left, level+1);
    }
}
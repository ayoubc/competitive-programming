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
    public String tree2str(TreeNode root) {
        String res = solve(root);
        if (res.isEmpty()) return res;
        return res.substring(1, res.length()-1);
    }
    private String solve(TreeNode root) {
        StringBuilder cur = new StringBuilder();
        cur.append('(');
        if (root != null) {
            cur.append(root.val);
            String left = solve(root.left);
            String right = solve(root.right);
            int cnt = 0;
            if (right.equals("()")) {
                if (!left.equals("()")) {
                    cur.append(left);
                }
            }
            else {
                cur.append(left);
                cur.append(right);
            }
        }
        cur.append(')');
        String res = cur.toString();
        return res;
    }
}
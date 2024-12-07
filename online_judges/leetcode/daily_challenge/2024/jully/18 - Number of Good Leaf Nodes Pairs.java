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
    Map<TreeNode, TreeNode> pars = new HashMap<>();
    List<TreeNode> leafs = new ArrayList<>();
    int ans;
    int limit;
    public int countPairs(TreeNode root, int distance) {
        limit = distance;
        parse(root, null);
        Set<TreeNode> seen = new HashSet<>();
        for(TreeNode leaf : leafs) {
            seen.clear();
            dfs(leaf, seen, 0);
        }
        return ans / 2;
    }
    private void parse(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (p != null) pars.put(root, p);
        if (root.left == null && root.right == null) leafs.add(root);
        parse(root.left, root);
        parse(root.right, root);
    }
    private void dfs(TreeNode s, Set<TreeNode> seen, int curDis) {
        if (curDis > limit) return;
        seen.add(s);
        if (s.left == null && s.right == null && curDis > 0) ans++;
        if (s.left != null && !seen.contains(s.left)) dfs(s.left, seen, curDis+1);
        if (s.right != null && !seen.contains(s.right)) dfs(s.right, seen, curDis+1);
        TreeNode par = pars.get(s);
        if (par != null && !seen.contains(par)) dfs(par, seen, curDis+1);
    }
}
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
    Map<Integer, TreeNode> pars = new HashMap<>();
    Map<Integer, TreeNode> node = new HashMap<>();


    public String getDirections(TreeNode root, int startValue, int destValue) {
        parse(root, null);
        Set<Integer> seen = new HashSet<>();
        Queue<Pair<TreeNode, String>> q = new LinkedList<>();
        q.add(new Pair<>(node.get(startValue), ""));
        String ans = "";
        seen.add(startValue);
        while (!q.isEmpty()) {
            Pair<TreeNode, String> p = q.poll();
            TreeNode n = p.getKey();
            String path = p.getValue();
            if (n.val == destValue) {
                ans = path;
                break;
            }
            if (n.left != null && !seen.contains(n.left.val)) {
                seen.add(n.left.val);
                q.add(new Pair<>(n.left, path+'L'));
            }
            if (n.right != null && !seen.contains(n.right.val)) {
                seen.add(n.right.val);
                q.add(new Pair<>(n.right, path+'R'));
            }
            TreeNode par = pars.get(n.val);
            if (par != null && !seen.contains(par.val)) {
                seen.add(par.val);
                q.add(new Pair<>(par, path+'U'));
            }
        }
        return ans;
    }
    private void parse(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (p != null) pars.put(root.val, p);
        node.put(root.val, root);
        parse(root.left, root);
        parse(root.right, root);
    }

}
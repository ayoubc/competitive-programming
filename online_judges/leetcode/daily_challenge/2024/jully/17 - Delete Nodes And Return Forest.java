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
    Map<Integer, TreeNode> parents = new HashMap<>();
    Map<Integer, TreeNode> nodes = new HashMap<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        parse(root, null);
        for(int v:to_delete) {
            TreeNode par = parents.get(v);
            if (par != null) {
                if (par.left != null && par.left.val == v) par.left = null;
                if (par.right != null && par.right.val == v) par.right = null;
            }
            TreeNode node = nodes.get(v);
            if (node.left != null) parents.remove(node.left.val);
            if (node.right != null) parents.remove(node.right.val);
            nodes.remove(v);
        }
        List<TreeNode> roots = new ArrayList<>();
        for(Integer d : nodes.keySet()) {
            if (!parents.containsKey(d)) roots.add(nodes.get(d));
        }
        return roots;
    }
    private void parse(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (p != null) parents.put(root.val, p);
        nodes.put(root.val, root);
        parse(root.left, root);
        parse(root.right, root);
    }
}
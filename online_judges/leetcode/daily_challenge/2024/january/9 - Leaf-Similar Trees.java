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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        parse(root1, leafs1);
        parse(root2, leafs2);
        if (leafs1.size() != leafs2.size()) return false;
        for(int i=0;i<leafs1.size();i++) {
            //System.out.println(leafs1.get(i) + " " + leafs2.get(i));
            if (leafs1.get(i) != leafs2.get(i)) return false;
        }
        return true;
    }
    private void parse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);
        parse(root.left, list);
        parse(root.right, list);
    }
}
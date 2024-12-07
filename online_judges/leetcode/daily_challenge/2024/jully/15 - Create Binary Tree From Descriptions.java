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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> child = new HashSet<>();
        for(int[] des:descriptions) {
            map.put(des[0], map.getOrDefault(des[0], getNode(des[0])));
            map.put(des[1], map.getOrDefault(des[1], getNode(des[1])));
            TreeNode par = map.get(des[0]);
            TreeNode ch = map.get(des[1]);
            if (des[2] == 1) par.left = ch;
            else par.right = ch;
            child.add(des[1]);
        }
        int root = -1;
        for (int[] des:descriptions) {
            if (child.contains(des[0])) continue;
            root = des[0];
            break;
        }
        return map.get(root);
    }
    private TreeNode getNode(int v) {
        return new TreeNode(v);
    }
}
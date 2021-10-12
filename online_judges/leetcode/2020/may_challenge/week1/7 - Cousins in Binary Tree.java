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
    private static int[] depth;
    private static int[] parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new int[101];
        parent = new int[101];
        depth[root.val] = 0;
        parent[root.val] = -1;
        traverse(root);
        
        if (parent[x] != parent[y] && depth[x] == depth[y]){
            return true;
        }
        return false;
    }
    
    public static void traverse (TreeNode root) {
        if (root.left != null) {
            depth[root.left.val] = depth[root.val] + 1;
            parent[root.left.val] = root.val;
            traverse(root.left);
        }
        if (root.right != null) {
            depth[root.right.val] = depth[root.val] + 1;
            parent[root.right.val] = root.val;
            traverse(root.right);
        }

    }
}
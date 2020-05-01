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
 
 Maximum(Diameter of left subtree, Diameter of right subtree, Longest path between two nodes which passes through the root.)
 
 Height of Tree = Max(Height of left SubTree, Height of Right SubTree) + 1
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        
        int d = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        
        return Math.max(lh+rh, d);
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
}
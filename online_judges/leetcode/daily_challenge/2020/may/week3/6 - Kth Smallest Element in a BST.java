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
    private List<Integer> items;
    public int kthSmallest(TreeNode root, int k) {
        items = new ArrayList<>();
        travers(root);
        Collections.sort(items);
        return items.get(k-1);
    }
    
    public void travers(TreeNode root) {
        if(root != null) {
            travers(root.left);
            items.add(root.val);
            travers(root.right);
        }
    }
}
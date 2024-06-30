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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        int n = inorder.size();
        TreeNode newRoot = new TreeNode(-1);
        addAll(newRoot, 0, n-1, inorder);
        return newRoot;
    }
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    private void addAll(TreeNode root, int s, int e, List<Integer> list) {
        if (s > e) return;
        int mid = (s + e) / 2;
        addNode(root, list.get(mid));
        addAll(root, mid+1, e, list);
        addAll(root, s, mid-1, list);
    }
    private void addNode(TreeNode root, int val) {
        if (root == null) return;
        if (root.val == -1) {
            root.val = val;
            return;
        }
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            }
            else addNode(root.right, val);
        }
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            }
            else addNode(root.left, val);
        }
    }
}
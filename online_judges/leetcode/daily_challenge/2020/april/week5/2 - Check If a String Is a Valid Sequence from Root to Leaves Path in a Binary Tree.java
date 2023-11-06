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
    boolean[] visited;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        int n = arr.length;
        if (arr==null ||  n == 0) return false;
        return check(root, 0, arr);
    }
    
    public boolean check(TreeNode cur, int i, int[] arr) {
        if (i == arr.length-1){
            return cur!=null && cur.val == arr[i] && cur.left == null && cur.right == null;
        }
        
        if (cur == null) return false;
        
        if (cur.val == arr[i]) {
            return check(cur.left, i + 1, arr) || check(cur.right, i + 1, arr);
        }
        
        else return false;

    }
    
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode tree = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++) {
            insert(tree, preorder[i]);
        }
        return tree;
    }
    public void insert(TreeNode head, int val) {
        TreeNode cur = head;
        while(true) {
            if (val > cur.val) {
                if (cur.right == null) break;
                else cur = cur.right;
            }
            else {
                if (cur.left == null) break;
                else cur = cur.left;
            }
        }
        if(cur.val < val) cur.right = new TreeNode(val);
        else cur.left = new TreeNode(val);
    }
}
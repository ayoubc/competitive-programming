/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        swapNodes(root);
        return root;
    }
    void swapNodes(TreeNode *root) {
        if(root == nullptr) return;
        swap(root->left, root->right);
        swapNodes(root->left);
        swapNodes(root->right);
    }
};

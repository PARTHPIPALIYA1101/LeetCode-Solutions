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
    int left(TreeNode root){
        if (root == null) return 0;
        int ctn=0;
        while(root.left!=null){
            ctn++;
            root=root.left;
        }
        return ctn;
    }
    int right(TreeNode root){
        if (root == null) return 0;
        int ctn=0;
        while(root.right != null){
            ctn++;
            root=root.right;
        }
        return ctn;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh=left(root);
        int eh=right(root);
        if(lh == eh) return ((2<<lh) -1);
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
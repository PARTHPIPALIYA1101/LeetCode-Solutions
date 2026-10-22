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
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        chk(root,null,null);
        return sum;
    }
    public void chk(TreeNode node,TreeNode parent,TreeNode grand){
        if(node == null) return;

        if(grand != null && grand.val % 2 == 0){
            sum+=node.val;
        }

        chk(node.left,node,parent);
        chk(node.right,node,parent);
    }
}
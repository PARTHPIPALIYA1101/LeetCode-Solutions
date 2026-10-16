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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        TreeNode root=build(preorder,inorder,0,preorder.length-1,0,inorder.length-1,mp);
        return root;
    }
    TreeNode build(int[]pre,int[] in,int pres,int pree,int ins,int ine,HashMap<Integer,Integer> mp){
        if(pres > pree || ins > ine) return null;
        TreeNode root=new TreeNode(pre[pres]);
        int inroot=mp.get(root.val);
        int numl=inroot-ins;
        root.left=build(pre,in,pres+1,pree+numl,ins,inroot-1,mp);
        root.right=build(pre,in,pres+numl+1,pree,inroot+1,ine,mp);
        return root;
    }
}
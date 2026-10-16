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
    public TreeNode buildTree(int[] in, int[] post) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<in.length;i++){
            mp.put(in[i],i);
        }
        TreeNode root=build(post,in,0,post.length-1,0,in.length-1,mp);
        return root;
    }
    TreeNode build(int[] post,int[] in,int ps,int pe,int is,int ie,HashMap<Integer,Integer> mp){
        if(ps > pe || is > ie) return null;
        TreeNode root=new TreeNode(post[pe]);
        int num=mp.get(root.val);
        int numl=num-is;
        root.left=build(post,in,ps,ps+numl-1,is,num-1,mp);
        root.right=build(post,in,ps+numl,pe-1,num+1,ie,mp);
        return root;
    }
}
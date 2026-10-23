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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> mp = new HashMap<>();
        markparent(root,mp,null);
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> ls=new ArrayList<>();
        q.offer(target);
        int ctn=0;
        Map<TreeNode,Boolean> visit= new HashMap<>();
        visit.put(target , true);
        while(!q.isEmpty()){
            if(ctn == k){
                break;
            }
            ctn++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                visit.put(curr,true);
                if(curr.left != null && !visit.containsKey(curr.left)) q.offer(curr.left);
                if(curr.right != null && !visit.containsKey(curr.right)) q.offer(curr.right);
                if(mp.containsKey(curr) && mp.get(curr) != null && !visit.containsKey(mp.get(curr))) q.offer(mp.get(curr));
            }
            
        }
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            ls.add(curr.val);
        }
        return ls;
    }
    void markparent(TreeNode root,Map<TreeNode,TreeNode> mp,TreeNode parent){
        if(root == null) return;
        mp.put(root,parent);
        if(root.left != null) markparent(root.left,mp,root);
        if(root.right != null) markparent(root.right,mp,root);
    }
}
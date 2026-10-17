class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] pre:edges){
            ls.get(pre[0]).add(pre[1]);
        }
        boolean[] vis=new boolean[V];
        boolean[] path=new boolean[V];
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!vis[i] && dfs(i,ls,vis,path,res)) return new int[0];
        }
        int ans[]=new int[res.size()];
        for(int i=res.size()-1;i>=0;i--) ans[i]=res.get(i);
        return ans;
    }
    boolean dfs(int node, List<List<Integer>> ls, boolean[] vis, boolean[] path, List<Integer> res){
        vis[node] = true;
        path[node] = true;
        for(int i:ls.get(node)){
            if(path[i]) return true;
            if(!vis[i] && dfs(i, ls, vis, path, res)) return true;
        }
        path[node] = false;
        res.add(node);
        return false;
    }
}
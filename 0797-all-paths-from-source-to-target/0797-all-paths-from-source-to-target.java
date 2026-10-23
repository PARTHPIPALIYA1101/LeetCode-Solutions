class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        ls.add(0);
        solve(ans,ls,0,graph.length-1,graph);
        return ans;
    }
    public void solve(List<List<Integer>> ans,List<Integer> ls,int src,int dst,int[][] g){
        if(src == dst){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int n:g[src]){
            ls.add(n);
            solve(ans,ls,n,dst,g);
            ls.remove(ls.size()-1);
        }
    }
}
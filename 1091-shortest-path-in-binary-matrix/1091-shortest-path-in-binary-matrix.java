class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        int dirx[]={-1,0,1,0,-1,1,1,-1};
        int diry[]={0,-1,0,1,-1,1,-1,1};
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int size=q.size();
            ans++;
            for(int i=0;i<size;i++){
                int c[]=q.poll();
                int x=c[0];
                int y=c[1];
                if(x== m-1 && y== n-1) return ans;
                for(int j=0;j<8;j++){
                    int nr=x+dirx[j];
                    int nc=y+diry[j];
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 0){
                        q.offer(new int[]{nr,nc});
                        grid[nr][nc] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
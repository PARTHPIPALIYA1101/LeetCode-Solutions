class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
        int[][] dis=new int[n][n];
        int res=0,s=n;
        for(int r[]:dis) Arrays.fill(r,10001);
        for(int[] e:edges){
            dis[e[0]][e[1]]=e[2];
            dis[e[1]][e[0]]=e[2];
        }
        for(int i=0;i<n;i++) dis[i][i]=0;
        for (int k = 0;k < n;k++)
            for (int i = 0;i < n;i++)
                for (int j = 0;j < n;j++)
                    if(dis[i][k] != 10001 && dis[k][j] != 10001)
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
        for(int i=0;i<n;i++){
            int ctn=0;
            for(int j=0;j<n;j++){
                if(i != j && dis[i][j] <= dt){
                    ctn++;
                }
            }
            if(ctn <= s){
                res=i;
                s=ctn;
            }
        }
        return res;
    }
}
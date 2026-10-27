class Solution {
    public String[] createGrid(int m, int n) {
        char[][] ans=new char[m][n];
        for(char[] r : ans) Arrays.fill(r,'#');
        if(m == 1){
            Arrays.fill(ans[0],'.');
        }
        else if(n == 1){
            for(int i=0;i<m;i++)ans[i][0]='.';
        }
        else{
            for(int i=0;i<n;i++)ans[0][i]='.';
            for(int i=0;i<m;i++)ans[i][n-1]='.';
        }
        String[] s=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb=new StringBuilder();
            for(char j:ans[i]){
                sb.append(j);
            }
            s[i]=sb.toString();
        }
        return s;
    }
}
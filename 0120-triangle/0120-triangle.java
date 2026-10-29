class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int[] dp=new int[t.size()];
        for(int i=0;i<t.size();i++){
            dp[i]=t.get(t.size()-1).get(i);
        }
        for(int i=t.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+t.get(i).get(j);
            }
        }
        return dp[0];
    }
}
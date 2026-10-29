class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for(int[] row:dp) java.util.Arrays.fill(row, -1);
        return dfs(nums, 0, target, dp);
    }
    
    int dfs(int[] nums , int idx , int target,int[][] dp){
        if(idx == nums.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        if(target < -1000 || target > 1000) return 0;
        if(dp[idx][target + 1000] != -1) return dp[idx][target + 1000];
        int add =dfs(nums, idx+1, target+nums[idx], dp);
        int sub =dfs(nums, idx+1, target-nums[idx], dp);
        return dp[idx][target + 1000] = add + sub;
    }
}
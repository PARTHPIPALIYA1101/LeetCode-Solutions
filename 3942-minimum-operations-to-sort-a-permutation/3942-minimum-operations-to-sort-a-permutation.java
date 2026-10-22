class Solution {
    public int minOperations(int[] nums) {
        int pos=0,n=nums.length;
        while(nums[pos]!=0) pos++;
        boolean a=true;
        boolean b=true;
        for(int i=0;i<n;i++){
            if(nums[i] != (i+nums[0])%n) a=false;
            if(nums[i] != (nums[0]-i+n)%n) b=false;
        }
        if(a) return Math.min(pos, 1 + n-pos + 1);
        if(b) return Math.min(1 + n - pos - 1, pos + 2);
        return -1;
    }
}
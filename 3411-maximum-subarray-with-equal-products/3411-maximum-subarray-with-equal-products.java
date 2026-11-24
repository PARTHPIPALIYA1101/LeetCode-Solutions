class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int ans=1;
        for(int i=0;i<n;i++){
            int g=0;
            int lc=1;
            int pro=1;
            for(int j=i;j<n;j++){
               g=gcd(g,nums[j]);
               pro=pro*nums[j];
               lc=lcm(lc,nums[j]);
               if(pro==g*lc){
                ans=Math.max(ans,j-i+1);
               }
            }
        }
        return ans;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
            
        }
        return a;
    }
    public int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
}
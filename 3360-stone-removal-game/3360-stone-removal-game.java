class Solution {
    public boolean canAliceWin(int n) {
        int r=10;
        boolean t=true;
        while(n>=r){
            n-=r;
            r--;
            t=!t;
        }
        return !t;
    }
}
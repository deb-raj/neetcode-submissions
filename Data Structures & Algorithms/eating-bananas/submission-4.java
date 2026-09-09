class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int num:piles){
            right=Math.max(right,num);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            int houres=0;
            for(int i=0;i<piles.length;i++){
                houres+=(piles[i]+mid-1)/mid;
            }
            if(houres<=h){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}

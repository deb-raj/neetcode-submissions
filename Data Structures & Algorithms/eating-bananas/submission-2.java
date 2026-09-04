class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int pill:piles){
            right=Math.max(right,pill);
        }
        while(left<=right){
            int hour=0;
            int mid=left+(right-left)/2;
            for(int i=0;i<piles.length;i++){
                hour+=(piles[i]+mid-1)/mid;
            }
            if(hour<=h){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}

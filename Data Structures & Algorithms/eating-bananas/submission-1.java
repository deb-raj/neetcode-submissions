class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
    
        for(int pill:piles){
            right=Math.max(pill,right);
        }
        while(left<=right){
            int mid= left+(right-left)/2;
            int hours=0;
            for(int i=0;i<piles.length;i++){
                hours+=(piles[i]+mid-1)/mid;
            }
            if(hours<=h){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}

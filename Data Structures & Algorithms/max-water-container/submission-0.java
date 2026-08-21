class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int max=0;
        while(left<right){
            int height=Math.min(heights[left],heights[right]);
            int weidth=right-left;
            int area=height*weidth;
            max=Math.max(max,area);
            if(heights[left]<heights[right]){
                left++;
            }else if(heights[left]>heights[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return max;
    }
}

//we need to set two pointer on left and right and check that two pointer value which is smaller one
//then we we multiply with that smaller ans *(left-right)index so we got a ans , and we store , w calculate all of this value , and store it on max , and return it . 
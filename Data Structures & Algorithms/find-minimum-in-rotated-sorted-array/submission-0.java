class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}
//demand :- the question is giving, one array which can be roteted in any times upto n , and also mention that all elements are unique , we need to return the minimum elment of this array .
//strongest signal:-  sorted in ascending order , return the minimum element of this array. ,can you write an algorithm that runs in O(log n) time. this 3 are stringest signal .
//we maintian one min varibale and check all the elemnts , and return the min.
//pattern :- binary search. 
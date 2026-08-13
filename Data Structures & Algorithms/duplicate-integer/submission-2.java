class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        while(l<r){
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
            l++;
            r--;
        }
        }
        return false;
    }
}
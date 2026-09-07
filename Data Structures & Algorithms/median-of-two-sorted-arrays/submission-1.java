class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int left=0;
        int right=m;
        int leftSize=(n+m+1)/2;
        while(left<=right){
            int cut1=left+(right-left)/2;
            int cut2=leftSize-cut1;
            int nums1Left;
            int nums1Right;
            if(cut1==0){
                nums1Left=Integer.MIN_VALUE;
            }else{
                nums1Left=nums1[cut1-1];
            }
            if(cut1==m){
                nums1Right=Integer.MAX_VALUE;
            }else {
                nums1Right=nums1[cut1];
            }
            int nums2Left;
            int nums2Right;
            if(cut2==0){
                nums2Left=Integer.MIN_VALUE;
            }else{
                nums2Left=nums2[cut2-1];
            }
            if(cut2==n){
                nums2Right=Integer.MAX_VALUE;
            }else{
                nums2Right=nums2[cut2];
            }
            if(nums1Left<=nums2Right && nums2Left<=nums1Right){
            int maxLeft=Math.max(nums1Left,nums2Left);
            int minRight=Math.min(nums1Right,nums2Right);
            if((m+n)%2==1){
                return maxLeft;
            }
                return (maxLeft+minRight)/2.0;
            }
            else if(nums1Left>nums2Right){
                right=cut1-1;
            }else {
                left=cut1+1;
            }

        }
        return 0.0;
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //swap smaller array to nums1;
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int leftSize=(m+n+1)/2;
        int left=0;
        int right=m;
        while(left<=right){
            int cut1 = left+(right-left)/2;
            int cut2=leftSize-cut1;

            //nums1 boundary Check
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
            //nums2 boundary Check 
            int nums2Left;
            int nums2Right;
            if(cut2==0){
                nums2Left=Integer.MIN_VALUE;
            }else{
                nums2Left=nums2[cut2-1];
            }
            if(cut2==n){
                nums2Right=Integer.MAX_VALUE;
            }else {
                nums2Right=nums2[cut2];
            }
            // valid partition 
            if(nums1Left<=nums2Right && nums2Left<=nums1Right){
                int maxLeft=Math.max(nums1Left , nums2Left);
                int minRight=Math.min(nums1Right , nums2Right);
                //odd total
                if((m+n)%2==1){
                    return maxLeft;
                }
                //even total
                 return (maxLeft + minRight) / 2.0;

               }
               // two many elment takens from nums1;
               else if(nums1Left>nums2Right){
                 right=cut1-1;
               }else{
                left=cut1+1;
               }

        }
        return 0.0;
    }
}


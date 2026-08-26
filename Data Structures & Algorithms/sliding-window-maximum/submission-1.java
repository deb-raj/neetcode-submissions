class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int left=0;
        int index=0;
        for(int right=0;right<nums.length;right++){
            pq.offer(new int[]{nums[right],right});
            if(right-left+1>k){
                left++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<left){
                pq.poll();
            }
            if(right-left+1==k){
                ans[index++]=pq.peek()[0];
            }
        }
        return ans;
    }
}

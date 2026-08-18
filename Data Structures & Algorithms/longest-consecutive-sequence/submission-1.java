class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int max=0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            if(set.contains(num-1)){
                continue;
            }
            int current=num;
            int count=1;
            while(set.contains(current+1)){
                current++;
                count++;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int max=0;
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            int right=i;
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
//we can use i directly instade of right, but for better understanding i used right variable.
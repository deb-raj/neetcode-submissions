class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;
        int maxFreq=0;
        int left=0;
        HashMap<Character,Integer>map=new HashMap<>();

        for(int right=0;right<s.length();right++ ){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);

            int frq=map.get(s.charAt(right));
            maxFreq=Math.max(frq,maxFreq);

            while(right-left+1-maxFreq>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            max=Math.max(right-left+1,max);
        }
        return max;
    }
}

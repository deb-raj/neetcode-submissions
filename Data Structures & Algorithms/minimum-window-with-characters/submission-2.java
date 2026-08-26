class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        HashMap<Character, Integer> tMap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int have=0;
        int need=tMap.size();
        int left=0;
        String value="";
        int min=Integer.MAX_VALUE;

        HashMap<Character,Integer>windowMap=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);
                
            if(tMap.containsKey(c) && tMap.get(c).equals(windowMap.get(c))){
                have++;
            }
            while(have==need){
                if(right-left+1<min){
                    min=right-left+1;
                    value=s.substring(left,right+1);
                }
                char l=s.charAt(left);
                windowMap.put(l,windowMap.get(l)-1);
                if(tMap.containsKey(l) && windowMap.get(l)<tMap.get(l)){
                    have--;
                }
                left++;
            }
        }
        return value;
    }
}

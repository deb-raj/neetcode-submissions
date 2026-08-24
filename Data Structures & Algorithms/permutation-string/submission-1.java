class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1freq[] = new int[26];
        int windowfreq[] = new int[26];
        int left = 0;
        if(s1.length()>s2.length()){
            return false;
        }
        for (int right = 0; right < s1.length(); right++) {
            s1freq[s1.charAt(right) - 'a']++;
        }
        for (int right = 0; right < s2.length(); right++) {

            windowfreq[s2.charAt(right) - 'a']++;

            if (right - left + 1 > s1.length()) {

                windowfreq[s2.charAt(left)-'a']--;
                left++;
            }
            if(right - left + 1 == s1.length() && Arrays.equals(s1freq,windowfreq)){
                return true;
            }
        }
        return false;
    }
}

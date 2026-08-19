class Solution {
    public boolean isPalindrome(String s) {
        char[]ch=s.toCharArray();
        int l=0;
        int r=ch.length-1;
        while(l<r){
              while(l<r && !Character.isLetterOrDigit(ch[l])){
            l++;
         }
           while(l<r && !Character.isLetterOrDigit(ch[r])){
            r--;
         }
            if(Character.toLowerCase(ch[l])!=Character.toLowerCase(ch[r])){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

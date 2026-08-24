class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer>map1=new HashMap<>();

        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i=0;i<=s2.length()-s1.length();i++){
            HashMap<Character,Integer>map2=new HashMap<>();
                for(int j=i;j<i+s1.length();j++){
                    map2.put(s2.charAt(j),map2.getOrDefault(s2.charAt(j),0)+1);
                }
                if(map1.equals(map2)){
                    return true;
                }
            }
            return false;
        }

    }

// demand:- the demand of this question is , there have a two ssstring s1 and s2 and we need to check that s1 string have presnt any substring in the s2 
// strongest signal :- That means if a permutation of s1 exists as a substring of s2, then return true.
//brutforce:- we travel s1 and and store the frequency and length , we travels the s2 and maintain k window , and if match the frequency soo we return true.. otherwise false 
//optimize:pending
//pattern :-pending
//why:-pending
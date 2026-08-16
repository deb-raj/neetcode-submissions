class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String>ans=new ArrayList<>();
        int i=0;
        while(i<str.length()){
        int delimiter = str.indexOf('#', i);
        int length = Integer.parseInt(
        str.substring(i, delimiter));
        String word = str.substring(delimiter + 1, delimiter + 1 + length);
         ans.add(word);
          i = delimiter + 1 + length;
        }
        return ans;
    }
}

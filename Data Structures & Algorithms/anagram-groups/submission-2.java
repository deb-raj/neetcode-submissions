class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>>map = new HashMap<>();

        for(String str : strs) {

            char[] arr =str.toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

            map.computeIfAbsent(key,k-> new ArrayList()).add(str);  //this line    basically replace the if else part .

        //    if(!map.containsKey(key)) {

        //     map.put(key,new ArrayList<>());
        //    }

        //    map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

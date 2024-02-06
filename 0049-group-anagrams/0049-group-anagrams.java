class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();
        //List<List<string>> = new ArrayList<>();
        
        for(String s: strs){
            char c[] = new char[26];
            for(Character ch : s.toCharArray()){
                c[ch-'a']++;
            }
            
            String str = new String(c);
            
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
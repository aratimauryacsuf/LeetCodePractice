class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
    if(strs == null || strs.length == 0) return new ArrayList<>();
        
    Map<String, List<String>> map = new HashMap<>();
    
    for(String s: strs){
        char[] ca = new char[26];
        for(char c: s.toCharArray()) ca[c -'a']++; 
        String strKey = String.valueOf(ca);
        if(!map.containsKey(strKey)) map.put(strKey, new ArrayList<>());
        map.get(strKey).add(s);
}
        
        return new ArrayList<>(map.values());
    }
}
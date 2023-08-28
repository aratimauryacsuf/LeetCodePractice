class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int start =0;
        int matched=0;
        int minLen = s.length()+1;
        int subStr = 0;
        
        for(int end=0;end<s.length();end++){
            char right = s.charAt(end);
            if(map.containsKey(right)){
                map.put(right, map.get(right)-1 );
                if(map.get(right) == 0) matched++;
            }
            
            while(matched == map.size()){
                if(minLen > end - start +1){
                    minLen = end -start+1;
                    subStr = start;
                }
                
                char del = s.charAt(start++);
                if(map.containsKey(del)){
                    if(map.get(del)==0) matched--;
                    map.put(del,map.get(del)+1);
                }
            }
        }
        
        return minLen>s.length()?"" : s.substring(subStr, subStr+minLen);
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start =0;
        int end =0;
        int max =0;
        
        if(s.length() <= 1) return s.length();
        
        Map<Character,Integer> map =new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            
            
            if(map.containsKey(c) && map.get(c) >0){
                max = Math.max(max, end -start);
               // System.out.println("max: "+max);
                
                while(map.get(c) != 0){
                    char charS =s.charAt(start);
                    map.put(charS,map.get(charS)-1);
                    start++;
                }
            }
            map.put(c,1);
            end++;
            
        }
         max = Math.max(max, end -start);
        
        return max;
        
    }
}
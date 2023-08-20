class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false; 
        
        Map<Character , Integer> sMap = new HashMap<>();
          
        for(int i=0; i<s.length(); i++){
            if(!sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i),1);
            }
            else{
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
            }
        }
        
        for(int i=0;i<t.length();i++){
            if(sMap.containsKey(t.charAt(i))){
                if(sMap.get(t.charAt(i)) >1){
                    sMap.put(t.charAt(i), sMap.get(t.charAt(i)) -1);
                }else{
                    sMap.remove(t.charAt(i));
                }
            }else{
                return false;
            }
        }  
        
        if(sMap.isEmpty()) return true;
        
        return false;
    }
}
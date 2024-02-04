class Solution {
    public String minWindow(String s, String t) {
      /* 
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
    */
        String result ="";
        if(s.length() == 0 || t.length() ==0) return result;
        int need = t.length();
        int have = 0;
        int left =0;
        int minWindow =Integer.MAX_VALUE;
        HashMap<Character, Integer> mapt = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        for(int i =0; i < t.length() ; i++){
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0)+1);
        }
        int start =0;
       for(int end =0; end < s.length(); end++){
           mapS.put(s.charAt(end),mapS.getOrDefault(s.charAt(end), 0)+1);
           if(mapt.containsKey(s.charAt(end)) && mapS.get(s.charAt(end)) <=
           mapt.get(s.charAt(end))){
               have++;
           }

           while(have == need){
               if(minWindow > end - start +1){
                   minWindow = end - start +1;
                   result = s.substring(start,end +1);
               }
               char removeCh = s.charAt(start);
               if(mapS.get(removeCh) == 1){
                   mapS.remove(removeCh);
               }else{
                   mapS.put(removeCh, mapS.get(removeCh)-1);
               }
               start++;
               if(mapt.containsKey(removeCh) && mapS.getOrDefault(removeCh,0) < (mapt.get(removeCh))){
                   have--;
               }
           }
       }

        return result;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
          //  System.out.println("c: "+c);
        }
        
        int start =0;
        int matched=0;
        int minLen = s.length()+1;
        int subStr = 0;
        
        for(int end=0;end<s.length();end++){
            char right = s.charAt(end);
            //System.out.println("right: "+ right);
            if(map.containsKey(right)){
                map.put(right, map.get(right)-1 );
                if(map.get(right) == 0) matched++;
                //System.out.println("matched: "+matched);
            }
            
            //System.out.println("start:"+start +"end:"+ end);
            
            while(matched == map.size()){
                //System.out.println("minLen:"+ minLen +"end-start"+ (end-start+1));
                if(minLen > end - start +1){
                    minLen = end -start+1;
                    subStr = start;
                   // System.out.println("minLen:"+ minLen +" substr:" + subStr);
                }
                
                char del = s.charAt(start++);
               // System.out.println("del: "+ del);
                if(map.containsKey(del)){
                    if(map.get(del)==0) matched--;
                    //System.out.println("matched at the del:"+matched);
                    map.put(del,map.get(del)+1);
                }
            }
        }
        
        return minLen>s.length()?"" : s.substring(subStr, subStr+minLen);
    }
}
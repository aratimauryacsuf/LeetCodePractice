class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        int[] res = new int[len+1];
        
        for(int i =0; i<= len; i++){
            String sub = s.substring(0, i);
           // System.out.println("outer: "+ sub);
            if(set.contains(sub)){
                res[i] = 1;
            }
            if(res[i]==1){
                for(int j = i; j<=len;j++){
                    String sub2 = s.substring(i, j);
                   //  System.out.println("inner: "+ sub2);
                    if(set.contains(sub2)){
                        res[j] =1;
                    }
                }
            }
            if(res[len]==1){
                return true;
            }
            
        }
        
      return res[len]==1;  
    }
}
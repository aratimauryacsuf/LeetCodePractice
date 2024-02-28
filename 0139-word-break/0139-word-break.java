class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int sol[] = new int[len+1];
        
        for(int i = 0; i <= len; i++){
            String sub = s.substring(0, i);
            //System.out.println("outer: " + sub);
            if(wordDict.contains(sub)){
                sol[i] = 1;
            }
            
            if(sol[i] == 1){
                for(int j = i; j <= len; j++){
                    String sub2 = s.substring(i, j);
                 //   System.out.println("inner: " + sub2);
                     if(wordDict.contains(sub2)){
                            sol[j] = 1;
                        }
                    }
                if(sol[len]==1)
                    return true;
            }
            
        }
        return sol[len]==1;
    }
}
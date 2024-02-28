class Solution {
    public boolean wordBreak(String s, List<String> wordDict1) {
        Set<String> wordDict = new HashSet<>(wordDict1);
        int len = s.length();
        int sol[] = new int[len+1];
        
        for(int i = 0; i <= len; i++){
            String sub = s.substring(0, i);
            if(wordDict.contains(sub)){
                sol[i] = 1;
            }
            
            if(sol[i] == 1){
                for(int j = i; j <= len; j++){
                    String sub2 = s.substring(i, j);
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
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        
        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);
        
        for(String word: wordList){
            StringBuilder string = null;
            for(int i=0; i<word.length();i++){
                string = new StringBuilder(word);
                string.setCharAt(i,'*');
                
                List<String> wordlist = adjList.getOrDefault(string.toString(), new ArrayList<>());
                wordlist.add(word);
                
                adjList.put(string.toString(), wordlist);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int noOfWords =1;
        
        StringBuilder string = null;
        
        while(!q.isEmpty()){
            noOfWords++;
            int size = q.size();
            
            for(int j = 0; j<size; j++){
                String str = q.poll();
                
                for(int i =0; i<str.length();i++){
                    string  = new StringBuilder(str);
                    string.setCharAt(i,'*');
                    
                    for(String pat: adjList.get(string.toString())){
                        if(pat.equals(endWord)){
                            return noOfWords;
                        }
                        if(visited.contains(pat)){
                            continue;
                        }
                        q.offer(pat);
                        visited.add(pat);
                        
                    }
                }
            }
        }
        
        
        
        return 0;
    }
}
class Trie {
    
    TrieNode head;
    
    public Trie() {
    
        head = new TrieNode(); 
    }
    
    public void insert(String word) {
        if(word == null) return; 
        
        TrieNode node = head;
        for(char ch : word.toCharArray()){
            if(!node.charToNode.containsKey(ch)){
               node.charToNode.put(ch, new TrieNode()); 
            }
            node = node.charToNode.get(ch);
        }
        node.isEnd = true;           
    }
    
    public boolean search(String word) {
        
        if(word == null) return false;
        
        TrieNode node = head;
        
        for(char ch : word.toCharArray()){
            if(!node.charToNode.containsKey(ch)){
                return false;
            }
            
            node = node.charToNode.get(ch);
        }
        
        return node.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        
        if(prefix == null){
            return false;
        }
        
        TrieNode node = head;
        
        for(char ch : prefix.toCharArray()){
            if(!node.charToNode.containsKey(ch)){
                return false;
            }
            node  = node.charToNode.get(ch);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode{
    Map<Character, TrieNode> charToNode;
    boolean isEnd= false;
    
    public TrieNode(){
        charToNode = new HashMap<>();
    }
}
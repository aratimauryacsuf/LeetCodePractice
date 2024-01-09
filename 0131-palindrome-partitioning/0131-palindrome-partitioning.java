class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        backtrack(0, s, res, list);
        return res;
    }
    
    public void backtrack(int start, String s, List<List<String>> res, List<String> list){
        
        if(start >= s.length()){
            res.add(new ArrayList<>(list));
        }
        for(int end = start; end < s.length(); end++){
            if(palindrome(s, start, end)){
                list.add(s.substring(start, end+1));
                backtrack(end+1, s, res, list);
                list.remove(list.size() -1);
            }
            
        }
    }
    
    public boolean palindrome(String s, int start, int end){
        while (start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
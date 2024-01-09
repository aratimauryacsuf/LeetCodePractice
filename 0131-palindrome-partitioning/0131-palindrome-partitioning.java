class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list  = new ArrayList<>();
        
        backtrack(0, s, res, list);
        return res;
    }
    
    public void backtrack(int start, String s, List<List<String>> res, List<String> list){
        
       // System.out.println("res at start of backtrack: "+  res);
       // System.out.println("start: "+  start);
        
        if(start >= s.length()){
           // System.out.println("in base case check: "+  res);
            res.add(new ArrayList<>(list));
            // System.out.println("in base case check after: "+  res);
        }
        
        for(int end = start; end < s.length(); end++){
           // System.out.println("end value: "+  end);
            if(palindrome(s, start, end)){
                list.add(s.substring(start, end+1));
               // System.out.println("list in for loop: "+  list);
                backtrack(end+1, s, res, list);
                list.remove(list.size()-1);
              //  System.out.println("list loop:  end of"+  list);
            }
        }
    }
    
    public boolean palindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
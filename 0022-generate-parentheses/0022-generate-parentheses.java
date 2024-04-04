class Solution {
    public List<String> generateParenthesis(int n) {
     List<String> list = new ArrayList<>();
        backtrack(list, "",0,0,n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open,int close, int max){
      //  System.out.println("Str: "+ str);
      //  System.out.println("Open: "+ open + " Close: "+ close);
        if(str.length() == 2*max){
            
          //  System.out.println("Str "+str +" added in a list");
            list.add(str);
            return;
        }
        
        if(open < max) backtrack(list, str+"(", open+1,close,max);
        
        if(close < open) backtrack(list,str+")", open, close+1,max);
        
    }
}
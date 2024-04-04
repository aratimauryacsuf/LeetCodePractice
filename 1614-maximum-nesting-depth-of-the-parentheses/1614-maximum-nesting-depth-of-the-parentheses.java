class Solution {
    public int maxDepth(String s) {
        int ans =0;
    /*    
        Stack<Character> st = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '('){
                st.push(c);
            }else if(c == ')'){
                st.pop();
            }
            
            ans = Math.max(ans, st.size());
        }
        */
        
        int openBracks =0;
        for(Character c: s.toCharArray()){
            if(c == '('){
                openBracks++;
            }
            if(c == ')'){
                openBracks--;
            }
            
            ans = Math.max(ans, openBracks);
        }
        
        return ans;
    }
}
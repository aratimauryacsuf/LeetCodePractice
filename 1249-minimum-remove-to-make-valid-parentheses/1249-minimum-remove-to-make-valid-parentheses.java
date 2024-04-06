class Solution {
    public String minRemoveToMakeValid(String s) {
      /*
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> todoRemove = new HashSet<>();
       
        for(int i =0 ; i< s.length(); i++){
            
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    todoRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        
        todoRemove.addAll(stack);
        
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< s.length() ; i++){
            if(!todoRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        
        return new String(sb);
        */
        
        int openCloseCount = 0;
		int close = 0;
		for (int i = 0; i < s.length(); i++)  if (s.charAt(i) == ')') close++;
		
        StringBuilder sb = new StringBuilder();
		
		for (char c: s.toCharArray()) {
			if (c == '(') {
				if (openCloseCount == close) continue;
				openCloseCount++;
			} else if (c == ')') {
				close--;
				if (openCloseCount == 0) continue;
				openCloseCount--;
			} 

				sb.append(c);
		}
		return sb.toString();
    }
}
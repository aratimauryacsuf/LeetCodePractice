class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i = expression.length()-1; i >=0; i--){
            if(!stack.isEmpty() && stack.peek() == '?'){
                stack.pop();
                char trueChar = stack.pop();
                stack.pop();
                char falseChar = stack.pop();
                stack.push(expression.charAt(i) == 'T' ? trueChar : falseChar);
            }
            else{ stack.push(expression.charAt(i));}
           
        }
       return String.valueOf(stack.peek()); 
    }
}
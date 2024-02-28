import java.util.*;

class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s", ""); // Remove spaces
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numStack.push(num);
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    evaluateTop(numStack, opStack);
                }
                opStack.pop(); // Pop the '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!opStack.isEmpty() && precedence(c) <= precedence(opStack.peek())) {
                    evaluateTop(numStack, opStack);
                }
                opStack.push(c);
            }
        }
        
        while (!opStack.isEmpty()) {
            evaluateTop(numStack, opStack);
        }
        
        return numStack.pop();
    }
    
    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
    
    private void evaluateTop(Stack<Integer> numStack, Stack<Character> opStack) {
        char op = opStack.pop();
        int b = numStack.pop();
        int a = numStack.pop();
        int result = 0;
        
        if (op == '+') result = a + b;
        else if (op == '-') result = a - b;
        else if (op == '*') result = a * b;
        else if (op == '/') result = a / b;
        
        numStack.push(result);
    }
}

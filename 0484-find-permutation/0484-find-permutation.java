class Solution {
    public int[] findPermutation(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[s.length() +1];
        int k =0;
        for(int i =1; i <= s.length(); i++){
            if(s.charAt(i -1) == 'I'){
                stack.push(i);
                while(!stack.isEmpty()){
                    res[k++] = stack.pop();
                }
            }
            else{
                    stack.push(i);
                }
        }
        stack.push(s.length() +1);
        while(!stack.isEmpty()){
            res[k++] = stack.pop();
        }
       return res; 
    }
}
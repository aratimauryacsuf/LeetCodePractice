class Solution {
    public int[] dailyTemperatures(int[] temp) {
       int n = temp.length;
        int ans[] = new int[n];
        
    Stack<Integer> stack = new Stack<>();
        
        for(int currD =0; currD < n; currD++){
            
            while(!stack.isEmpty() && temp[currD] > temp[stack.peek()]){
                int prevD = stack.pop();
                ans[prevD] = currD - prevD;
            }
            stack.push(currD);
        }
      return ans;  
    }
}
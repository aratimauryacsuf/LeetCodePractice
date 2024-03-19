class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1; 
        int n = arr.length;
        int temp =0;
        
        for(int i = n-1; i>=0;i--){
            temp = arr[i];
            arr[i] =max;
            max = Math.max(arr[i], temp);
        }
        
        return arr;
    }
}
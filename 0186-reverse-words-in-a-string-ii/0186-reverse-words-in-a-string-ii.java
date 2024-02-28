class Solution {
    public void reverseWords(char[] s) {
      int n = s.length;
      reverse(s,0, n -1);
      int start =0;
     for(int end =0; end < s.length; end++){
       if(s[end] == ' '){
         reverse(s, start, end-1);
         start = end +1;
       }
     }
     reverse(s,start,n-1);
        
    }
    public void reverse(char[] s, int left, int right){
      while(left < right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
      }

    }
}
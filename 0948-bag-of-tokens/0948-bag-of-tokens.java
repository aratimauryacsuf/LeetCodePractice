class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score =0;
         if( tokens.length ==1 && tokens[0] > power){
            return score;
        }
        Arrays.sort(tokens);
        int left =0;
        int right= tokens.length-1;
        int ans = 0;
       
        
        while(left <=right){
            if(tokens[left] <= power){
                //System.out.println("token left: "+ tokens[left] );
                score = score +1;
                power = power - tokens[left];
                // System.out.println("power left: "+ power );
                ans = Math.max(ans, score);
                left++;
            }
            else if(score > 0){
                // System.out.println("token right: "+ tokens[right] );
                power = power + tokens[right];
               // System.out.println("power right: "+ power );
                score  =score -1;
                right--;
            }else{
                break;
            }
        }
        
        return ans;
    }
}
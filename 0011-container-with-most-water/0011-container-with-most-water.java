class Solution {
    public int maxArea(int[] h) {
        
        // Brute force
        /*
        int res =0;
 
        for(int l =0; l< h.length;l++){
            for(int r =l+1;r<h.length;r++){
                int area = (r-l)* Math.min(h[l],h[r]);
                res = Math.max(res,area);
            }
        }
        
        return res;
        */
        
        // linear 
        
        int res =0;
        int left = 0;
        int right = h.length -1;
        
        while(left < right){
            int area = (right - left)* Math.min(h[left],h[right]);
            res = Math.max(res,area);
            
            if(h[left] < h[right]) left++;
            else if(h[left] > h[right]) right--;
            else{
                left++;
                right--;
            }
                
            
        }
        
        
        return res;
    }
}
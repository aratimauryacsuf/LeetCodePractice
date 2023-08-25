class Solution {
    public int trap(int[] h) {
        int[] leftMax = new int[h.length];
        int[] rightMax = new int[h.length];
        int maxL=0;
        int maxR=0;
        int totW =0;
        for(int i =0 ; i< h.length;i++){
            maxL = Math.max(maxL,h[i]);
            leftMax[i] =maxL;
        }
        for(int i =h.length-1 ; i>=0 ;i--){
            maxR = Math.max(maxR,h[i]);
            rightMax[i] =maxR;
        }
        
        for(int i =0;i<h.length;i++){
            int minH = Math.min(leftMax[i],rightMax[i]);
            totW = totW + minH - h[i];
        }
        
        return totW;
    }
}
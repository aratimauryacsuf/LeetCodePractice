class Solution {

    int[] runningSum;
    public Solution(int[] w) {
        runningSum = new int[w.length];
        int sum = 0;
        for(int i = 0; i<w.length; i++){
            runningSum[i] = sum + w[i];
            sum = runningSum[i];
        }
    }
    
    public int pickIndex() {
        int sum = runningSum[runningSum.length-1];
        //System.out.println("sum: "+ sum);
        int random = (int)(Math.random()*sum)+1;
       // System.out.println("random: "+ random);
        for (int i = 0; i < runningSum.length; i++){
            if(random <= runningSum[i])
                return i;
        }
        return 0;
    }
    public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
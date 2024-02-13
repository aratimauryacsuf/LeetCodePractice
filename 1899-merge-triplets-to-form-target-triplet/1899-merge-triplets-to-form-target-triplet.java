class Solution {
    public boolean mergeTriplets(int[][] ts, int[] tar) {
        int[] res = new int[tar.length];
        
        for(int[] t: ts){
           
            if(t[0] <= tar[0] && t[1] <= tar[1] && t[2] <= tar[2]){
                res[0] = Math.max(t[0], res[0]);
                res[1] = Math.max(t[1], res[1]);
                res[2] = Math.max(t[2], res[2]);
                
                //or this one line
                // res = new int[]{ Math.max(res[0], s[0]), Math.max(res[1], s[1]), Math.max(res[2], s[2]) };
            }
        }
            
        
    
       //return Arrays.equals(res,tar);
        return res[0] == tar[0] && res[1] == tar[1] && res[2] == tar[2];
    }
}
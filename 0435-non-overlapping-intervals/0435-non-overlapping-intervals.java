class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        
       // LinkedList<int[]> ans = new LinkedList<>();
        int[] prev = intervals[0];
        int remove =0;
        
        for(int i= 1; i < intervals.length;i++){
            if(prev[1] > intervals[i][0]){
               remove++;
                if(prev[1] > intervals[i][1]){
                    prev = intervals[i];
                }
            }else{
                prev = intervals[i];
            }
        }
        
        return remove;
    }
}
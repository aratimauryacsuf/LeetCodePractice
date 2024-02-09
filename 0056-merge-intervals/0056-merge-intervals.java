class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
         LinkedList<int[]> ans = new LinkedList<>();
        
//          int temp[] = intervals[0];
//         if(intervals.length <= 1){
            
//             return intervals;
//         }
//         for(int i =1; i<intervals.length; i++){
            
//             if(temp != null && temp[1] < intervals[i][0]){
//                 ans.add(temp);
//             }
//             else if(temp[1] >= intervals[i][0] ){
//                 temp[0] = Math.min(intervals[i][0], temp[0]);
//                 temp[1]= Math.max(intervals[i][1], temp[1]);
//                 ans.add(temp);
//                 temp = null;
//             }
//                 ans.add(intervals[i]);
                
            
                                     
//         }
        
        for(int[] interval: intervals){
            if(ans.isEmpty() || ans.getLast()[1] < interval[0]){
                ans.add(interval);
            }else{
                ans.getLast()[1] =Math.max(ans.getLast()[1], interval[1]);
            }
        }
        
        
        return ans.toArray(new int[ans.size()][]);
        
    }
}
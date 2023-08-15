class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();

        for(int[] i : intervals){
            if(newInterval == null || i[1] < newInterval[0]){
                output.add(i) ;
            }else if(i[0] > newInterval[1]){
                    output.add(newInterval);
                    output.add(i);
                    newInterval = null;

                }
            else{
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
                }
        }
        if(newInterval != null)
         output.add(newInterval);
        

        return output.toArray(new int[output.size()][]) ;
    }
}
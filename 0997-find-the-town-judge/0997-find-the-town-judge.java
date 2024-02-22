class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] count = new int[n+1];
        
        for(int[] t: trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        
        for(int i =1; i<=n; i++){
            if(count[i] == n-1) 
                return i;
        }
        
        return -1;
        
//        // if(trust.length == n) return -1;
        
//         HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
//        int[] res = new int[n];
//         int sum =0;
        
//        // int judge = trust[0][];
//         for(int i =0; i<trust.length;i++){
//             // if(res[trust[i][0] -1] == 0)
//             //     res[trust[i][0] -1] = -1;
            
//             if(!map.containsKey(trust[i][0])){
//                 map.put(trust[i][0], new HashSet<>());
//             }
//        Set<Integer> value = map.get(trust[i][0]);
//             value.add(trust[i][1]);
//            map.put(trust[i][0], value);   
//         }
        
//         int judge =-1;
//         for(int i=0; i<n; i++){
//             if(res[i] ==0 ){
//                 if(judge != -1){
//                    return -1; 
//                 }else 
//                     judge =i+1;
                           
//             }
                
//         }
        
//         return judge;
    }
}
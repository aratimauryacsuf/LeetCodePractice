import java.util.SortedMap;
class Solution {
    public int[] topKFrequent(int[] a, int k) {
        int [] res = new int[k];
        int j =0;
        Map<Integer,Integer> map = new HashMap<>();
		SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>(Collections.reverseOrder());

        
     for(int i = 0; i<a.length; i++){
         map.put(a[i], map.getOrDefault(a[i], 0)+1);
     }   
      for(Map.Entry<Integer, Integer> entry : map.entrySet()){
         if(sortedMap.containsKey(entry.getValue())){
             sortedMap.get(entry.getValue()).add(entry.getKey());
         }
          else{
              List<Integer> list = new ArrayList<>();
              list.add(entry.getKey());
              sortedMap.put(entry.getValue(), list);
          }
          
      }          
        for(Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()){
            List<Integer> list = entry.getValue();
            if(j==k)
                break;
            for(int num : list){
                 res[j++] = num;
                    if(j == k)
                         break;
            }
         
      }  
        
        return res;
    }
}
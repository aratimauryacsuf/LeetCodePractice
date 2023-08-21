import java.util.SortedMap;
class Solution {
    public int[] topKFrequent(int[] a, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i< a.length;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(!sortedMap.containsKey(e.getValue())){
                sortedMap.put(e.getValue(), new ArrayList<>());
            }
            sortedMap.get(e.getValue()).add(e.getKey());
        }
        
        int[] res = new int[k];
        int j = 0;
        
        for(Map.Entry<Integer,List<Integer>> se : sortedMap.entrySet()){
            List<Integer> list = se.getValue();
            if(j==k) break;
            
            for(int n : list){
                res[j++] = n;
                if(j == k) break;
            }
        }
        
        return res;
    }
}
       
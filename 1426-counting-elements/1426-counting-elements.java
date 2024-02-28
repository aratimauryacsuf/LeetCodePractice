class Solution {
    public int countElements(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =0;
        for(int i =0; i < arr.length; i++){
        
                 map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(int key : map.keySet()){
            if(map.containsKey(key +1)){
                count += map.get(key);
               
            }
        }
        return count;
    }
}
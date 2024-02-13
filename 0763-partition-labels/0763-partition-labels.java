class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< s.length(); i++){
               map.put(s.charAt(i), i);            
        }
        
        int size =0;
        int end =0;
        
        for(int i =0; i< s.length(); i++){
            if(end < map.get(s.charAt(i))){
                end = map.get(s.charAt(i));
            }
            size++;
            
            if(end == i){
                res.add(size);
                size=0;
            }
        }
        
        return res;
        
    }
}
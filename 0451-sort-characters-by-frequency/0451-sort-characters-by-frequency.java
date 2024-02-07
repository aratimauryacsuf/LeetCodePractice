class Solution {
    class Pair{
            char val1;
            int val2;
            Pair(char x, int y){
                this.val1 = x;
                this.val2=y;
            }
        }
        

    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1,p2) ->p2.val2 -p1.val2);
        
        StringBuilder sb = new StringBuilder();
        
        for(Map.Entry<Character,Integer> e : map.entrySet())
            maxHeap.add(new Pair(e.getKey(),e.getValue()));
        
        while(!maxHeap.isEmpty()){
            Pair p = maxHeap.remove();
            for(int i =0; i< p.val2 ;i++){
                sb.append(p.val1);
            }
        }
        
        return sb.toString();
    }
}
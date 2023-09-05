class LRUCache {

    Map<Integer, Integer> map ;
    int capacity;
   // List<Integer>  list = new ArrayList<>();
    Deque<Integer> q  = new ArrayDeque<>();
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(! map.containsKey(key)){
                //System.out.println("Get Map" + map);
            return -1;
        }
        else
        {
        q.remove(key);
        q.addFirst(key);
        //System.out.println("Get Map" + map);
        return map.get(key); 
        }
       
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            q.remove(key);
            q.addFirst(key);
           // System.out.println("check capacity Map" + map);
        }else{
            if(map.size() == capacity){
                map.remove(q.pollLast());
            }
            q.addFirst(key);
            map.put(key, value); 
        }        
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
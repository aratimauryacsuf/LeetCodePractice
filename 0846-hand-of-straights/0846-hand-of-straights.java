class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int handLen = hand.length;
        if(handLen % groupSize != 0) return false;
        
        Map<Integer, Integer> count =new HashMap<>();
        
        for(int i : hand){
            count.put(i, count.getOrDefault(i,0)+1);
        }
        
        Arrays.sort(hand);
        
        for(int i =0 ;i < handLen; i++){
            if(count.get(hand[i])==0){
                continue;
            }
            
            for(int j =0; j<groupSize;j++){
                int num = hand[i]+j;
                
                if(count.getOrDefault(num,0)==0){
                    return false;
                }
                
                count.put(num , count.get(num)-1);
                
            }
        }
        
        return true;
    }
}
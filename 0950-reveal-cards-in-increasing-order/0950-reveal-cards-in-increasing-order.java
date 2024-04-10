class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0; i< len ; i++)
            q.offer(i);
        
        int[] result = new int[len];
        for(int i =0;i<len;i++){
            result[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        
        return result;
    }
}
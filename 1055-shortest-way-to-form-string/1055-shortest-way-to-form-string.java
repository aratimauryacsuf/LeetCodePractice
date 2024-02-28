class Solution {
    public int shortestWay(String source, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : source.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char c : target.toCharArray()){
            while(!map.containsKey(c)){
                 return -1;
            }
        }
        int m = source.length();
        int sourceIterator =0;
        int count =0;
        for(char c : target.toCharArray()){
            if(sourceIterator == 0){
                count++;
            }
            while(source.charAt(sourceIterator)!= c){
                sourceIterator = (sourceIterator + 1)%m;
                 if(sourceIterator == 0){
                count++;
            }
            }
            sourceIterator = (sourceIterator + 1)%m;
        }
        return count;
    }
}
class Solution {
    public boolean validWordSquare(List<String> words) {
         int numRows = words.size(); 
       

        for(int i =0; i <numRows; i++){
           for(int j =0; j < words.get(i).length(); j++){
              if( j >= numRows || i >=  words.get(j).length() || 
              words.get(i).charAt(j) != words.get(j).charAt(i))
              return false;

           }
        }
       return true; 
    }
}

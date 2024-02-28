/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int noOfpeople;
    public int findCelebrity(int n) {
        int celeb =0;
        noOfpeople =n;
        for(int i =0; i < n ; i++){
            if(knows(celeb, i)){
                celeb =i;
            }
        }
         if(isCelebrity(celeb)){
                return celeb;
            }
        return -1; 
    }
    private boolean isCelebrity(int i){
        for(int j =0; j < noOfpeople; j++){
            if(i == j) continue;
            if(knows(i,j) || !knows(j,i)){
                return false;
            }
        }
        return true;
    }
}
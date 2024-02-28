class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count =0;
        int row = picture.length;
        int col = picture[0].length;
        int[] rowCount = new int[row];
        int[] colCount = new int[col];


        for(int i =0; i < picture.length; i++){
            for(int j =0; j < picture[i].length; j++){
             
                  if(picture[i][j] == 'B'){
                   rowCount[i]++;
                   colCount[j]++;
              }
            }
        }

         for(int i =0; i < picture.length; i++){
            for(int j =0; j < picture[i].length; j++){
             
                  if(picture[i][j] == 'B' &&  rowCount[i] ==1 &&  colCount[j] ==1){
                  count++;
              }
            }
        }


       return count; 
    }
}
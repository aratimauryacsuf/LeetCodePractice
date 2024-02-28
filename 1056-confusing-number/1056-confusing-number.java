class Solution {
    public boolean confusingNumber(int N) {
        int[] rotate = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int num = N;
        int rotated = 0;

        while (num > 0) {
            int d = num % 10;
            if (rotate[d] < 0)
                return false;
            rotated = rotated * 10 + rotate[d];
            num /= 10;
        }

        return rotated != N;
    }
}
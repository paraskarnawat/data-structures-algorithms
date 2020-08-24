package codes.arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] result = new int[N];
        int i = 0;
        int j = N - 1;
        for (int k = N - 1; k >= 0; k--) {
            int left = Math.abs(A[i]);
            int right = Math.abs(A[j]);
            if (left > right) {
                result[k] = A[i] * A[i];
                i++;
            } else {
                result[k] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
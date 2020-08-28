package codes.arrays;

public class SortByParity {
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) {
                int temp = A[start];
                A[start] = A[i];
                A[i] = temp;
                start++;
            }
        }
        return A;
    }
}
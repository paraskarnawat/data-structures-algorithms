package codes.arrays;

public class ValidMountainArrayBF {
    public boolean validMountainArrayBF(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            maxIndex = (A[maxIndex] < A[i]) ? i : maxIndex;
        }

        if (maxIndex == A.length - 1 || maxIndex == 0) {
            return false;
        }

        for (int i = maxIndex; i > 0; i--) {
            if (A[i] <= A[i - 1]) {
                return false;
            }
        }
        for (int i = maxIndex; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
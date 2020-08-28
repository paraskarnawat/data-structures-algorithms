package codes.arrays;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] < A[i]) {
                left = i;
                break;
            } else if (A[i + 1] == A[i]) {
                return false;
            }
        }

        for (int i = A.length - 1; i > 0; i--) {
            if (A[i - 1] < A[i]) {
                right = i;
                break;
            } else if (A[i - 1] == A[i]) {
                return false;
            }
        }

        if (left != right || left == 0 || right == A.length - 1) {
            return false;
        }

        return true;
    }
}
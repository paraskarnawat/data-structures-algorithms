package codes.arrays;

public class DuplicateZerosBF {
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            if (arr[i] == 0) {
                arr[j] = 0;
                j++;
                while ((j + 1) < arr.length) {
                    arr[j] = arr[j + 1];
                    j++;
                }
            }
        }
    }
}
package codes.arrays;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int count = 0;
        int N = arr.length;

        for (int i : arr)
            if (i == 0)
                count++;

        for (int i = N - 1; i >= 0; i--) {
            int temp = i + count;
            if (temp < N) {
                arr[temp] = arr[i];
            }
            if (arr[i] == 0) {
                temp--;
                count--;
                if (temp < N) {
                    arr[temp] = arr[i];
                }
            }
        }
    }
}
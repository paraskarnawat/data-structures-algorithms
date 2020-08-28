package codes.arrays;

public class ReplaceWithMaxRight {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = Integer.max(arr[i], max);
            arr[i] = max;
            max = temp;
        }
        return arr;
    }
}
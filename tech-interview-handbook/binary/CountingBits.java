package binary;

public class CountingBits {
    public int[] countBits(int num) {
        int k = 0;
        int[] result = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            // if the number is power of 2
            if ((i & (i - 1)) == 0) {
                k = 0;
            }
            result[i] = 1 + result[k];
            k++;
        }
        return result;
    }
}

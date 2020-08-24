package codes.arrays;

public class EvenDigitNumbersBF {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            int temp = n;
            int digits = 0;
            while (temp > 0) {
                temp = temp / 10;
                digits++;
            }
            if ((digits & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
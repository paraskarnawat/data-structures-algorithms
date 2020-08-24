package codes.arrays;

public class EvenDigitNumbers {
    public int findNumbers(int[] nums) {
        int count = 0;
        // Constraints says that nums[i] <= 10^5
        // So, any number between [10^1, 10^2) and
        // [10^3, 10^4) and 10^5 has even digits
        for (int n : nums) {
            if (n >= 10 && n < 100) { // 2 digits
                count++;
            } else if (n >= 1000 && n < 10000) { // 4 digits
                count++;
            } else if (n == 100000) {
                count++;
            }
        }
        return count;
    }
}
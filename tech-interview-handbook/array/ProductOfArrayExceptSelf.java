package array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];

        int product = 1;

        /**
         * Compute the product for the left of current element
         */
        for (int i = 0; i < N; i++) {
            result[i] = product;
            product = product * nums[i];
        }

        product = 1;

        /**
         * Compute the product for the right of current element, and multiply
         */
        for (int i = N - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * nums[i];
        }

        return result;
    }
}

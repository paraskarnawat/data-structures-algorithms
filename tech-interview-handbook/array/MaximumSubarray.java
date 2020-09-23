package array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSoFar, currentSum;
        maxSoFar = currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Integer.max(nums[i], nums[i] + currentSum);
            maxSoFar = Integer.max(currentSum, maxSoFar);
        }

        return maxSoFar;
    }
}

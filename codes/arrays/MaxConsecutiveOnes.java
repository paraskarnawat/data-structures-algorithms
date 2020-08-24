package codes.arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(final int[] nums) {
        int maxUntilNow = 0, maxOverall = 0;
        for (final int num : nums) {
            maxUntilNow = (num == 0) ? 0 : maxUntilNow + 1;
            maxOverall = Integer.max(maxOverall, maxUntilNow);
        }
        return maxOverall;
    }
}
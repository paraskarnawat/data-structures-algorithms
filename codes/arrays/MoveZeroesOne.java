package codes.arrays;

public class MoveZeroesOne {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[start++] = n;
            }
        }
        while (start < nums.length)
            nums[start++] = 0;
    }
}
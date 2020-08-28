package codes.arrays;

public class RemoveDupFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[length++] = nums[i];
            }
        }
        return length;
    }

}
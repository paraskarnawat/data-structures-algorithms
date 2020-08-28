package codes.arrays;

public class RemoveDupFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        int start = 0;
        for (int num : nums) {
            if (start == 0 || num > nums[start - 1]) {
                nums[start++] = num;
            }
        }
        return start;
    }

}
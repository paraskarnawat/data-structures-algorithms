package codes.arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int start = 0;
        for (int num : nums) {
            if (num != val) {
                nums[start++] = num;
            }
        }
        return start;
    }

}
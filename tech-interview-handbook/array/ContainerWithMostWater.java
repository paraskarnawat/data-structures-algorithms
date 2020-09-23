package array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int area = 0;

        while (left < right) {
            int currentArea = Integer.min(height[left], height[right]) * (right - left);
            area = Integer.max(area, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}

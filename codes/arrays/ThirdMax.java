package codes.arrays;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        Integer firstMax, secondMax, thirdMax;
        firstMax = secondMax = thirdMax = null;

        for (Integer i : nums) {

            if (i.equals(firstMax) || i.equals(secondMax) || i.equals(thirdMax)) {
                continue;
            }

            if (firstMax == null || firstMax < i) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            } else if (secondMax == null || secondMax < i) {
                thirdMax = secondMax;
                secondMax = i;
            } else if (thirdMax == null || thirdMax < i) {
                thirdMax = i;
            }

        }

        if (thirdMax == null) {
            return firstMax;
        }
        return thirdMax;
    }
}
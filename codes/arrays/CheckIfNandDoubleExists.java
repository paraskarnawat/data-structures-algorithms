package codes.arrays;

import java.util.HashSet;

public class CheckIfNandDoubleExists {
    public boolean checkIfExists(int[] arr) {
        if (arr.length <= 1) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(2 * arr[i]) || (((arr[i] & 1) == 0) && set.contains(arr[i] / 2))) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
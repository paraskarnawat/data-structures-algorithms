package codes.arrays;

public class HeightChecker {

    /*
     * Consider the following example, heights[] = {2, 3, 1, 2, 1}
     * frequencyOfHeights[] = {0, 2, 2, 1, ...}
     * 
     * Now, if heights[i] != frequencyIndex (1), it means that this height is out of
     * place. If there are more than one heights at that index, we stay at that
     * index until we can say that, we will move to next height.
     * 
     */
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] frequencyOfHeights = new int[101];

        int frequencyIndex = 0;

        for (int height : heights) {
            ++frequencyOfHeights[height];
        }

        for (int i = 0; i < heights.length; i++) {
            /*
             * If there is no height at current `frequencyIndex`, find the index where
             * height is present.
             */
            while (frequencyOfHeights[frequencyIndex] == 0) {
                frequencyIndex++;
            }

            if (heights[i] != frequencyIndex) {
                count++;
            }
            frequencyOfHeights[frequencyIndex]--;
        }
        return count;
    }

}
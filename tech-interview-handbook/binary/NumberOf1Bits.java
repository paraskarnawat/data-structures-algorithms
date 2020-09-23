package binary;

public class NumberOf1Bits {
    // number of set bits is also called as hamming weight
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

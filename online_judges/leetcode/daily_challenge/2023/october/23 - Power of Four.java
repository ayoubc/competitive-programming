class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        int mask = 0x55555555;
        // ensure n is power of two by first condition
        // endure the set bit in odd position in binary representation
        return (n & (n - 1)) == 0 && (n & mask) == n;
    }
}
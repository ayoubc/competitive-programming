/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int n = dim.get(0), m = dim.get(1);
        int res = -1;
        int l = 0, r = m - 1;
        while(l<=r) {
            int mid = l + (r - l) / 2;
            boolean found = false;
            for(int i=0;i < n; i++) {
                if (binaryMatrix.get(i, mid) == 1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                res = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        
        return res;
    }
    
}
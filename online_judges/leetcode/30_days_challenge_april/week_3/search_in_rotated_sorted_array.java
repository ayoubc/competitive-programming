class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(0, n - 1, nums);
        if (pivot == -1) return binarySearch(0, n - 1, nums, target);
        
        if (nums[pivot] == target) return pivot;
        if (nums[0] <= target) return binarySearch(0, pivot - 1, nums, target);
        return binarySearch(pivot+1, n - 1, nums, target);
    }
    
    public int binarySearch(int l, int r, int[] nums, int val) {
        if (r>=l) {
            int mid = l + (r - l)/2;
            if (nums[mid] == val) return mid;
            if(nums[mid] < val) return binarySearch(mid +1,r, nums,val) ;
            return binarySearch(l , mid - 1, nums,val) ;
        }
        return -1;
    } 
    public int findPivot(int l, int r, int[] nums) {
        if (r < l) return -1;
        if (r == l) return l;
        
        int mid = l + (r - l)/2;
        
        if (mid < r  && nums[mid] > nums[mid+1]) return mid;
        if (mid > l && nums[mid] < nums[mid-1]) return mid - 1;
        
        if(nums[l] < nums[mid]) return findPivot(mid+1, r, nums);
        return findPivot(l, mid-1, nums);
    } 
}
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<l.length;i++) {
            int[] tmp = new int[r[i] - l[i] + 1];
            for(int j=l[i]; j<=r[i]; j++) {
                tmp[j-l[i]] = nums[j];
            }
            Arrays.sort(tmp);
            int diff = tmp[1] - tmp[0];
            boolean canBe = true;
            for(int j=2;j<tmp.length;j++) {
                if (diff != tmp[j] - tmp[j-1]) {
                    canBe = false;
                    break;
                }
            }
            ans.add(canBe);
        }
        return ans;
    }
}
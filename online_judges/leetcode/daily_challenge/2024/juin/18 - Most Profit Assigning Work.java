class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = difficulty.length;
        int m = worker.length;
        List<Pair<Integer, Integer>> diffIndex = new ArrayList<>();
        for(int i=0;i<n;i++) {
            diffIndex.add(new Pair<>(difficulty[i], i));
        }
        diffIndex.sort((p1, p2) -> {
            return Integer.compare(p1.getKey(), p2.getKey());
        });
        int[] sortedProfit = new int[n];
        for(int i=0;i<n;i++){
            int val = profit[diffIndex.get(i).getValue()];
            if (i == 0) sortedProfit[i] = val;
            else sortedProfit[i] = Math.max(val, sortedProfit[i-1]);
        }
        int ans = 0;
        for(int i=0;i<m;i++) {
            int l = 0;
            int r = n-1;
            int index = -1;
            
            while(l<=r) {
                int mid = l + (r - l) / 2;
                if (diffIndex.get(mid).getKey() <= worker[i]) {
                    l = mid+1;
                    index = mid;
                }
                else r = mid-1;
            }
            if (index != -1) ans += sortedProfit[index];
        }
        return ans;
    }
}
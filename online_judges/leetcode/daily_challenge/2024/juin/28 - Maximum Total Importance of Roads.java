class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        for(int[] road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        List<Integer> tmp = IntStream.range(0, n).boxed()
                .collect(Collectors.toList());
        tmp.sort((v1, v2) -> {
            return Long.compare(degree[v1], degree[v2]);
        });

        long[] importance = new long[n];

        for(int i=0;i<n;i++) {
            importance[tmp.get(i)] = i+1;
        }
        long ans = 0;
        for(int[] road:roads) ans += importance[road[0]] + importance[road[1]];
        return ans;
    }
}
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> {
            int c = Integer.compare(p1[0], p2[0]);
            if (c == 0) c = Integer.compare(p1[1], p2[1]);
            return c;
        });

        int n = pairs.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0])
                    d[i] = Math.max(d[i], d[j] + 1);
            }
        }

        int ans = d[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, d[i]);
        }
        return ans+1;
    }
}
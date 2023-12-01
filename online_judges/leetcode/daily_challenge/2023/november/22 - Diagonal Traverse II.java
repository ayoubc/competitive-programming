class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<P> ans = new ArrayList<>();

        for(int i=0;i<nums.size();i++) {
            int m = nums.get(i).size();
            for(int j=0;j<m;j++) ans.add(new P(i+j, i, nums.get(i).get(j)));
        }
        Collections.sort(ans);

        return ans.stream().mapToInt(p -> p.val).toArray();
    }
    private class P implements Comparable<P> {
        int s;
        int r;
        int val;
        public P(int sum, int row, int v) {
            s = sum;
            r = row;
            val = v;
        }
        @Override
        public int compareTo(P other) {
            int c = Integer.compare(s, other.s);
            if (c == 0) c = Integer.compare(r, other.r) * -1;
            return c;
        }
    }
}
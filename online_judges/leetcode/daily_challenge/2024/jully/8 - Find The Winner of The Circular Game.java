class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] vis = new boolean[n];
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++) l.add(i+1);
        int cnt = n;
        int cur = 0;
        while (l.size() > 1) {
            cur = (cur + k - 1) % l.size();
            l.remove(cur);
        }
        return l.get(0);
    }
}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Map<Integer, Integer> occ = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int h : hand) {
            int hocc = occ.getOrDefault(h, 0);
            if (hocc == 0) {
                pq.add(h);
            }
            occ.put(h, hocc+1);
        }
        while (!pq.isEmpty()) {
            if (pq.size() < groupSize) return false;
            int last = -1;
            int cnt = 0;
            List<Integer> toAdd = new ArrayList<>();
            while (cnt < groupSize) {
                int ele = pq.poll();
                if (last == -1) last = ele;
                else if (ele - last != 1) return false;
                last = ele;
                cnt++;
                if (occ.get(last) > 1) {
                    toAdd.add(last);
                    occ.put(last, occ.get(last)-1);
                }
            }
            for(Integer d : toAdd) pq.add(d);
        }
        return true;
    }
}
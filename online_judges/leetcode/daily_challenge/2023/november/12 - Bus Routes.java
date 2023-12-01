class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<routes.length;i++) {
            for(int stop : routes[i]) {
                Set<Integer> s = graph.getOrDefault(stop, new HashSet<>());
                s.add(i);
                graph.put(stop, s);
            }
        }

        Set<Integer> sourceBus = graph.get(source);

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        for(Integer d: sourceBus) {
            q.add(new Pair<>(d, 1));
            seen.add(d);
        }
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int bus = p.getKey();
            int cnt = p.getValue();

            for(int i=0;i<routes[bus].length;i++) {
                int stop = routes[bus][i];
                if (stop == target) return cnt;

                for(Integer d : graph.get(stop)) {
                    if (seen.contains(d)) continue;
                    q.add(new Pair<>(d, cnt+1));
                    seen.add(d);
                }
            }
        }

        return -1;
    }
}
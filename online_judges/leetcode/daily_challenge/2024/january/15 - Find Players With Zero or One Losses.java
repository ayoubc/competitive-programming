class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losers = new HashMap<>();
        Map<Integer, Integer> winners = new HashMap<>();
        for(int[] arr: matches) {
            winners.put(arr[0], winners.getOrDefault(arr[0], 0) + 1);
            losers.put(arr[1], losers.getOrDefault(arr[1], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>()); 
        ans.add(new ArrayList<>());
        Set<Integer> all = new HashSet<>(winners.keySet());
        all.addAll(losers.keySet());
        for(Integer d: all) {
            if (!losers.containsKey(d)) ans.get(0).add(d);
            else if (losers.get(d) == 1) ans.get(1).add(d);
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
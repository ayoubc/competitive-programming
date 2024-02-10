class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occ = new HashMap<>();
        for(int d:arr) {
            occ.put(d, occ.getOrDefault(d, 0) + 1);
        }
        Set<Integer> unic = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry: occ.entrySet()) unic.add(entry.getValue());
        return unic.size() == occ.entrySet().size();
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Map<Integer, String> mp = new HashMap<>();
        for(int i=0;i<n;i++) mp.put(heights[i], names[i]);
        Arrays.sort(heights);
        String[] ans = new String[n];
        for(int i=n-1;i>=0;i--) ans[n-i-1] = mp.get(heights[i]);
        return ans;
    }
}
class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> hm = new HashMap<String, String>();
        for(List<String> list: paths) {
            hm.put(list.get(0), list.get(1));
        }
        String ans = paths.get(0).get(0);
        while(hm.containsKey(ans)) {
            ans = hm.get(ans);
        }
        return ans;
    }
}
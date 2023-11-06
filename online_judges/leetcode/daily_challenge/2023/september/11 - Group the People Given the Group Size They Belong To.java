class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++) {
            boolean found = false;
            for(List<Integer> l : ans) {
                if (l.size() < groupSizes[i]) {
                    boolean ok = true;
                    for(Integer d : l) {
                        if (groupSizes[d] != groupSizes[i]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        l.add(i);
                        found = true;
                        break;
                    }
                }
            }
            if(!found) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
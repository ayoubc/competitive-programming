class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] index = new int[1001];
        int OO = 1500;
        Arrays.fill(index, OO);
        for(int i=0;i<arr2.length;i++) index[arr2[i]] = i;
        List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        list.sort((e1, e2) -> {
            int idx1 = index[e1];
            int idx2 = index[e2];
            if (idx1 == OO && idx2 == OO) return Integer.compare(e1, e2);
            else return Integer.compare(idx1, idx2);
        });
        return list.stream().mapToInt(i->i).toArray();
    }
}
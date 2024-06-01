class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        //System.out.println(Math.min(v1.length, v2.length));
        for (int i=0;i<Math.min(v1.length, v2.length);i++) {
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);
            //System.out.println(n1 + " " + n2);
            if (n1 == n2) continue;
            else if (n1 < n2) return -1;
            else return 1;
        }
        if (v1.length == v2.length) {
            //System.out.println("here");
            return 0;
        }
        else if (v1.length < v2.length) {
            for (int i=v1.length;i<v2.length;i++) {
                if (Integer.parseInt(v2[i]) != 0) return -1;
            }
            return 0;
        }
        else {
            for (int i=v2.length;i<v1.length;i++) {
                if (Integer.parseInt(v1[i]) != 0) return 1;
            }
            return 0;
        }
    }
}
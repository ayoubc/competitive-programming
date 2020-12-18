class Solution {
    public String frequencySort(String s) {
        List<Char> listChar = new ArrayList<>();
        int[] occ = new int[256];
        for(char c : s.toCharArray()) {
            occ[c - ' ']++;
        }
        for(char c : s.toCharArray()) {
            listChar.add(new Char(c, occ[c - ' ']));
        }
        Collections.sort(listChar);

        return listChar.stream().map(x -> String.valueOf(x.getC())).collect(Collectors.joining());
    }
    static class Char implements Comparable<Char> {
        private char c;
        private int occ;

        public Char(char c, int occ) {
            this.c = c;
            this.occ = occ;
        }

        public int getOcc() {
            return occ;
        }

        public char getC() {
            return c;
        }

        @Override
        public int compareTo(Char o) {
            if(o.getOcc() == this.getOcc()) {
                return o.getC() - this.getC();
            }
            return o.getOcc() - this.getOcc();
        }
    }
}
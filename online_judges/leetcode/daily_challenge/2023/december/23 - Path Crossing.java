class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<Pair<Integer, Integer>> seen = new HashSet<>();
        seen.add(new Pair<>(x, y));
        for(int i=0;i<path.length();i++) {
            char c = path.charAt(i);
            if (c == 'N') x -= 1;
            if (c == 'S') x += 1;
            if (c == 'E') y += 1;
            if (c == 'W') y -= 1;
            Pair<Integer, Integer> p = new Pair<>(x, y);
            if (seen.contains(p)) return true;
            seen.add(p);
        }
        return false;
    }
}
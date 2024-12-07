import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static InputReader in;
    static PrintWriter out;
    static int seek;
    static boolean isPart2 = false;
    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);

        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) lines.add(line);
        seek = 0;
        out.println(part2(lines));
        out.close();
    }

    private static int getCharW(char c) {
        if (c >= '2' && c <= '9') return c - '0';
        if (c == 'T') return 10;
        if (c == 'J') {
            if (isPart2) return 1;
            return 11;
        }
        if (c == 'Q') return 12;
        if (c == 'K') return 13;
        return 14;
    }
    private static long part1(List<String> lines) {
        List<Bid> bids = lines.stream().map(s -> {
            String[] tmp = s.split(" ");
            return new Bid(tmp[0], tmp[1]);
        }).collect(Collectors.toList());
        Collections.sort(bids);
        long ans = 0;
        for (int i=0;i<bids.size();i++) {
            ans += (i + 1) * bids.get(i).bid;
        }
        return ans; // 255048101
    }
    private static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); // 253718286
    }
    static class Hand implements Comparable<Hand>{
        char[] hand;
        Map<Character, Integer> occ;
        List<Character> uniq;
        public Hand(String h) {
            hand = h.toCharArray();
            occ = new HashMap<>();
            uniq = new ArrayList<>();
            for (char c: hand) {
                Integer k = occ.getOrDefault(c, 0);
                if (k == 0) uniq.add(c);
                occ.put(c, k+1);
            }
            Collections.sort(uniq, (c1, c2) -> occ.get(c1) - occ.get(c2));
        }
        public boolean isSame() {
            return uniq.size() == 1;
        }
        public boolean isFour() {
            if (uniq.size() == 2) {
                return occ.get(uniq.get(0)) == 1 && occ.get(uniq.get(1)) == 4;
            }
            return false;
        }
        public boolean isFullHouse() {
            if (uniq.size() == 2) {
                return occ.get(uniq.get(0)) == 2 && occ.get(uniq.get(1)) == 3;
            }
            return false;
        }
        public boolean isThree() {
            if (uniq.size() == 3) {
                return occ.get(uniq.get(0)) == 1 && occ.get(uniq.get(1)) == 1 && occ.get(uniq.get(2)) == 3;
            }
            return false;
        }
        public boolean isTwoPair() {
            if (uniq.size() == 3) {
                return occ.get(uniq.get(0)) == 1 && occ.get(uniq.get(1)) == 2 && occ.get(uniq.get(2)) == 2;
            }
            return false;
        }
        public boolean isOnePair() {
            return uniq.size() == 4;
        }
        public boolean isHigh() {
            return uniq.size() == 5;
        }
        public int handRank() {
            if (isSame()) return 7;
            if (isFour()) return 6;
            if (isFullHouse()) return 5;
            if (isThree()) return 4;
            if (isTwoPair()) return 3;
            if (isOnePair()) return 2;
            return 1;
        }
        public int getW() {
            if (isPart2) return getNewW();
            return handRank();
        }
        public int getNewW() {
            // get best you can with Joker card J
            int occJ = occ.getOrDefault('J', 0);
            if (occJ == 0) return handRank();

            int currentW = handRank();
            if (currentW >= 5) return 7;
            if (currentW == 4) return 6;
            if (currentW == 3) {
                if (occJ == 1) return 5;
                return 6;
            }
            if (currentW == 2) return 4;
            return 2;
        }
        @Override
        public int compareTo(Hand o) {
            int c = Integer.compare(getW(), o.getW());
            if (c == 0) {
                for (int i=0;i<hand.length;i++) {
                    if (hand[i] != o.hand[i]){
                        c = Integer.compare(getCharW(hand[i]), getCharW(o.hand[i]));
                        break;
                    }
                }
            }
            return c;
        }
    }
    static class Bid implements Comparable<Bid>{
        Hand hand;
        long bid;
        public Bid(String s, String b) {
            hand = new Hand(s);
            bid = Long.parseLong(b);
        }
        @Override
        public int compareTo(Bid o) {
            return hand.compareTo(o.hand);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                return null;
            }
        }
    }
}

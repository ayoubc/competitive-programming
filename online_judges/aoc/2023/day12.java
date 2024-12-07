import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static InputReader in;
    static PrintWriter out;
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
        out.println(part1(lines));
        out.close();
    }

    private static long part1(List<String> lines) {
        long ans = 0;
        for (String line: lines) {
            String[] tmp = line.split(" ");
            List<Integer> broken = Arrays.stream(tmp[1].split(",")).map(Integer::parseInt).toList();
            long x = countArrangements(0, tmp[0], "", broken);

            ans += x;
        }
        return ans;
    }
    static boolean isGood(String s, List<Integer> brokenInts) {
        List<String> brokenStr = Arrays.stream(s.split("\\.+")).filter(it -> !it.isEmpty()).toList();
        if (brokenStr.size() != brokenInts.size()) return false;
        for (int i=0;i<brokenStr.size();i++) {
            if (brokenStr.get(i).length() != brokenInts.get(i)) return false;
        }
        return true;
    }
    static long countArrangements(int idx, String origin, String curS, List<Integer> broken) {
        if (curS.length() == origin.length()) {
            if (isGood(curS, broken)) return 1L;
            return 0L;
        }
        long res = 0;
        if (origin.charAt(idx) != '?') res += countArrangements(idx+1, origin, curS + origin.charAt(idx), broken);
        else {
            res += countArrangements(idx+1, origin, curS + '.', broken);
            res += countArrangements(idx+1, origin, curS + '#', broken);
        }
        return res;
    }
    private static long part2(List<String> lines) {
        return lines.size();
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

import java.io.*;
import java.util.*;


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
    private static Map<String, P> readMap(List<String> lines) {
        Map<String, P> res = new HashMap<>();
        while (seek < lines.size()) {
            String[] strs = lines.get(seek).split(" = ");
            res.put(strs[0], new P(strs[1].substring(1, strs[1].length() - 1).split(", ")));
            seek++;
        }
        return res;
    }
    private static long part1(List<String> lines) {
        char[] instructions = lines.get(seek).toCharArray();
        seek += 2;
        Map<String, P> map = readMap(lines);
        return getStepsToEnd("AAA", instructions, map); // 17621
    }
    private static boolean stopCondition(String start) {
        if (isPart2) return start.endsWith("Z");
        return start.equals("ZZZ");
    }
    private static long getStepsToEnd(String start, char[] instructions, Map<String, P> map) {
        int i=0;
        int ans = 0;
        while (!stopCondition(start)) {
            start = map.get(start).getAttr(instructions[i]);
            i = (i + 1) % instructions.length;
            ans ++;
        }
        return ans; // 17621
    }
    private static long part2(List<String> lines) {
        isPart2 = true;
        char[] instructions = lines.get(seek).toCharArray();
        seek += 2;
        Map<String, P> map = readMap(lines);
        List<String> starts = new ArrayList<>();
        for (String start: map.keySet()) {
            if (start.endsWith("A")) starts.add(start);
        }
        List<Long> steps = new ArrayList<>();
        for (String s: starts) {
            steps.add(getStepsToEnd(s, instructions, map));
        }

        return lcm(steps); // 20685524831999
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
    private static long lcm(List<Long> nums) {
        long res = 1;
        for (Long n: nums) res = lcm(res, n);
        return res;
    }
    static class P {
        String left;
        String right;
        public P(String[] strs) {
            left = strs[0];
            right = strs[1];
        }
        public String getAttr(char c) {
            if (c == 'L') return left;
            return right;
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

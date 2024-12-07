import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
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
        isPart2 = false;
        long ans = 0;
        for (String line: lines) ans += extrapolate(line);
        return ans;
    }
    private static long extrapolate(String line) {
        List<Long> diffs = Arrays.stream(line.split(" ")).map(Long::parseLong).toList();
        List<Long> elements = new ArrayList<>();
        boolean stop = false;
        while (!stop) {
            elements.add(isPart2 ? diffs.get(0) : diffs.get(diffs.size()-1));
            List<Long> cur = new ArrayList<>();
            int cnt = 0;
            for (int i=1;i<diffs.size();i++) {
                long diff = diffs.get(i) - diffs.get(i-1);
                if (diff == 0) cnt++;
                cur.add(diff);
            }
            stop = cnt == cur.size();
            diffs = cur;
        }
        long ans = 0;
        if (isPart2) for (int i=elements.size()-1;i>=0;i--) ans = elements.get(i) - ans;

        else for (Long x: elements) ans += x;
        return ans;
    }
    private static long part2(List<String> lines) {
        isPart2 = true;
        long ans = 0;
        for (String line: lines) ans += extrapolate(line);
        return ans;
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

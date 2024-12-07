import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static InputReader in;
    static PrintWriter out;
    static int seek;
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

    private static long part1(List<String> lines) {
        List<Long> times = Arrays.stream(lines.get(0).split("\\s+")).skip(1).map(Long::parseLong).toList();
        List<Long> distances = Arrays.stream(lines.get(1).split("\\s+")).skip(1).map(Long::parseLong).toList();

        long ans = 1;
        for (int i=0;i<times.size();i++) {
            int cnt = 0;
            long t = times.get(i);
            long d = distances.get(i);
            for (int j=1;j<t;j++) {
                cnt += (j * (t - j) > d ? 1 : 0);
            }
            if (cnt > 0) ans *= cnt;
        }
        return ans;
    }

    private static long part2(List<String> lines) {
        long time = Long.parseLong(Arrays.stream(lines.get(0).split("\\s+")).skip(1).collect(Collectors.joining()));
        long distance = Long.parseLong(Arrays.stream(lines.get(1).split("\\s+")).skip(1).collect(Collectors.joining()));

        long ans = 0;
        for (int j=1;j<time;j++) {
            ans += (j * (time - j) > distance ? 1 : 0);
        }
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

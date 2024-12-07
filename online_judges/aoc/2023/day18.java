import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {
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

    static long part1(List<String> lines) {
        List<P> points = new ArrayList<>();
        long x = 0;
        long y = 0;
        long B = 0;
        for (String line: lines) {
            String[] parts = line.split(" ");
            int len = Integer.parseInt(parts[1]);
            B += len;
            char direction = parts[0].charAt(0);
            if (direction == 'R') {
                x += len;
            }
            if (direction == 'L') {
                x -= len;
            }
            if (direction == 'U') {
                y -= len;
            }
            if (direction == 'D') {
                y += len;
            }
            points.add(new P(x, y));
        }
        long area = 0;
        for (int i=0; i<points.size(); i++) {
            int j = i == 0 ? points.size() - 1 : i - 1;
            P p = points.get(j);
            P q = points.get(i);
            area += (p.y - q.y) * (p.x + q.x);
        }
        // Pick's Theorem
        // polygon has coordonates as integers
        // area = I + B / 2 - 1 ==> I points stricly inside, B points on polygon edges
        return Math.abs(area) / 2 + 1 + B / 2; // 46359
    }

    static long part2(List<String> lines) {
        char[] dirs = {'R', 'D', 'L', 'U'};
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            String color = parts[2].substring(1, parts[2].length()-1);
            char dir = dirs[color.charAt(color.length()-1) - '0'];
            String hex = color.substring(1, color.length()-1);
            newLines.add(dir + " " + Integer.parseInt(hex, 16));
        }
        return part1(newLines); // 59574883048274
    }
    static class P {
        long x, y;

        public P(long i, long j) {
            x = i;
            y = j;
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
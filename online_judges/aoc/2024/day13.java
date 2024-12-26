import java.io.*;
import java.util.*;


public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static int mod = (1 << 31) - 1;
    static long OO = (long) Math.pow(10, 13);
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
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
        List<String> lines = new ArrayList<>();
        while (true) {
            try {
                String line = in.readLine();
                if (line == null) break;
                lines.add(line);
            } catch (Exception e) {
                System.err.println(e);
                break;
            }
        }
        out.println(part2(lines));
        out.close();
    }


    public static long[] getCoords(String line) {
        String[] parts = line.split(": ")[1].split(", ");
        return new long[]{Long.parseLong(parts[0].split("[\\+=]")[1]),
                Long.parseLong(parts[1].split("[\\+=]")[1])};
    }
    public static long part1(List<String> lines) {
        List<M> machines = new ArrayList<>();

        for(int i=0;i<lines.size();i+=4) {
            M m = new M(getCoords(lines.get(i)),
                    getCoords(lines.get(i+1)),
                    getCoords(lines.get(i+2)));
            for (int j=0;j<2;j++) m.pz[j] += isPart2 ? OO:0;
            machines.add(m);
        }
        long ans = 0;
        for (M machine : machines) {
            long cost = minCost(machine);
            if (cost == Long.MAX_VALUE) continue;
            ans += cost;
        }
        /*

        A * ax + B * bx = pzx

        A * ay + B * by = pzy
        pzx >= 300 * ax and pzx >= 100 bx or pzy >=
         */
        return ans; //29517
    }


    public static long minCost(M m) {
        long res = Long.MAX_VALUE;
        long A = m.b[1] * m.pz[0] - m.b[0] * m.pz[1];
        long B = m.a[0] * m.b[1] - m.a[1] * m.b[0];
        long C = m.a[0] * m.pz[1] - m.a[1] * m.pz[0];
        if (A % B == 0 && C % B == 0) {
            long X = A/B;
            long Y = C/B;
            if (X > 0 && Y > 0) res = 3 * X + Y;
        }
        return res;
    }
    public static long diophantine(long a1, long b1, long c1, long a2, long b2, long c2) {
        long res = Long.MAX_VALUE;
        P p = extendedEuclid(a1, b1);

        if (c1 % p.d == 0) {
            long x0 = p.x * (c1 / p.d);
            long y0 = p.y * (c1 / p.d);
            if (x0 < 0 && y0 < 0) return res;
            if (x0 >= 0 && y0 >= 0) {
                if (x0 * a2 + y0 * b2 != c2) return res; //95077997989483
                else return 3 * x0 + y0;
            }
            long A =  (a2 * b1 / p.d - a1 * b2 / p.d) * (x0 < 0 ? 1:-1);
            long B = c2 - b2 * y0 - a2 * x0;

            if (A * B >= 0 && B % A == 0) {
                long k = B / A;
                long x = x0 + (x0>0 ? -1:1) * (b1 / p.d) * k;
                long y = y0 + (y0>0 ? -1:1) * (a1 / p.d) * k;
                return 3 * x + y;
            }
        }
        return res;
    }
    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); //103570327981381
    }
    public static P extendedEuclid(long a, long b) {
        if (b == 0) return new P(a, 1, 0);

        P p = extendedEuclid(b, a % b);
        long x = p.y;
        long y = p.x - (a / b) * p.y;
        return new P(p.d, x, y);
    }
    record P(long d, long x, long y) { }
    record M(long[] a, long[] b, long[] pz) {};
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String readLine() throws IOException {
            return reader.readLine();
        }
    }
}
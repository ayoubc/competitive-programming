
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static boolean[] vis;
    static char[][] grid;
    static int cnt;
    static boolean found;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int N = 1000001;


        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int ans = 0;
            vis = new boolean[b - a + 1];
            for (int x=a;x<=b;x++) {
                if (!vis[x-a]) {
                    ans += solveOne(x, a, b);
                }
            }
            out.println(ans);
        }
        out.close();

    }

    static int solveOne(int n, int a, int b) {
        TreeSet<Integer> res = new TreeSet<>();
        int l = ten(n);
        int tmp = n;
        int x = n;
        res.add(tmp);
        while (tmp >= 10) {
            tmp /= 10;
            int d = x % 10;
            x /= 10;
            x += power(10, l) * d;
            if (x>=n && x <= b) res.add(x);
        }
        int total = 0;
        int i = 0;
        int sz = res.size();
        for (Integer p: res){
            vis[p-a] = true;
            total += sz - i - 1;
            i++;
        }

        return total;
    }

    static int ten(int x) {
        int k = 0;
        while (x > 0) {
            x /= 10;
            k++;
        }
        return k-1;
    }
    static int power(int x, int n) {
        if (n == 0) return 1;
        if(n == 1) return x;
        int b = power(x, n/2);
        b *= b;
        if (n % 2 == 1) b *= x;
        return b;
    }

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
    }
}
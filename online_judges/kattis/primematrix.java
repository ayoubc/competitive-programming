
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    static int[][] ans;
    static HashSet<Integer> primes = new HashSet<>();
    static boolean found = false;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        solve(in, out);
        out.close();
    }
    static void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int b = in.nextInt();

        int[] a = new int[n];
        ans = new int[n][n];
        if(n == b) {
            int x = ((n + 1) * n) / 2;
            if (isPrime(x)) {
                found = true;
                for (int i=0;i<n;i++) a[i] = i+1;
                fillAns(a, n);
            }
        }
        else if (n < b) {
            b = n + 1;
            solveOne(a, 0, 0, -1, n, b);
        }

        if (!found) out.println("impossible");
        else {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) out.print(ans[i][j] + " ");
                out.println();
            }
        }
    }

    static void fillAns(int[] a, int n) {
        int start = 0;
        for (int i=0;i<n;i++) {
            for (int j=start;j<n;j++) {
                ans[i][j-start] = a[j];
            }
            for (int j=0;j<start;j++) {
                ans[i][j + n - start] = a[j];
            }
            start ++;
        }
    }
    static void solveOne(int[] a, int curMax, int sum, int index, int n, int b) {
        if (index == n-1) {
            if (isPrime(sum) && !found) {
                fillAns(a, n);
                found = true;
                return;
            }
        }

        else if(!found) {
            for (int i=curMax+1; i<=b; i++) {
                a[index+1] = i;
                solveOne(a, i, sum+i, index+1, n, b);
            }
        }

        return;
    }
    static boolean isPrime(int x) {
        if (primes.contains(x)) return true;
        if (x < 2) return false;
        if (x == 2) {
            primes.add(x);
            return true;
        }
        if (x % 2 == 0) return false;
        int q = (int) Math.sqrt(x) + 1;
        for (int i=3;i<q;i+=2) {
            if (x % i == 0) return false;
        }
        primes.add(x);
        return true;
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
        public double nextDouble() {return Double.parseDouble(next());}
    }
}
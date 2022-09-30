import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    static int MAX = 1000001;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int tt=1;tt<=t;tt++){
            int n = in.nextInt();
            int[] S = new int[n];
            int[] occ = new int[MAX];

            HashSet<Integer> set = new HashSet<>();
            for (int i=0;i<n;i++) {
                S[i] = in.nextInt();
            }

            Arrays.sort(S);
            int x = 1;
            int index = 0;
            for (;x<MAX;x++) {
                index = bs(x, index, S);
                if (index == -1) break;

                index++;
            }

            out.println("Case #" + tt + ": " + (x-1));
        }
        out.close();
    }

    static int bs(int x, int s, int[] arr) {
        int l = s, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
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
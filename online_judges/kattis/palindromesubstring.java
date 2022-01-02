
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static int a,b,m,sigma;
    static char[][] grid;

    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        while(true) {
            try{
                String b = in.next();
                TreeSet<String> ans = solve(b);
                for (String str: ans) out.println(str);
                out.println();
            } catch (NullPointerException e) {
                break;
            }
        }

        out.close();
    }
    public static TreeSet<String> solve(String b) {
        TreeSet<String> pal = new TreeSet<>();
        char[] chars = b.toCharArray();
        int n = chars.length;
        for (int i=0; i< n; i++) {
            int r = i+1;
            int l = i-1;
            String tmp = String.valueOf(chars[i]);
            while (l>=0 && r<n && chars[r] == chars[l]) {
                tmp = chars[r] + tmp + chars[l];
                pal.add(tmp);
                r ++;
                l --;
            }

            tmp = "";
            r = i+1;
            l = i;
            while (l>=0 && r<n && chars[r] == chars[l]) {
                tmp = chars[r] + tmp + chars[l];
                pal.add(tmp);
                r ++;
                l --;
            }
        }
        return pal;
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
    }
}
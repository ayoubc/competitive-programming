import java.io.*;
import java.util.*;


public class Main {

    static char[][] grid;

    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        double[] r = new double[n];
        for (int i=0;i<n;i++) r[i] = in.nextDouble();
        char[] line = in.next().toCharArray();
        Stack<Double> rs = new Stack<>();
        Stack<Character> ops = new Stack<>();
        String cur = "";
        for (int i=0;i<line.length;i++) {
            if (line[i] == '-' || line[i] == '|') {
                ops.add(line[i]);
                if (!cur.isEmpty()) {
                    rs.add(r[getIndex(cur)]);
                }
                cur = "";
            }
            else if (line[i] == '(') {
                ops.add(line[i]);
                cur = "";
            }
            else if (line[i] == ')') {
                if (!cur.isEmpty()) rs.add(r[getIndex(cur)]);
                while(!ops.isEmpty()) {
                    char c = ops.pop();
                    if (c == '(') break;
                    double d1 = rs.pop();
                    double d2 = rs.pop();
                    rs.add(getREq(d1, d2, c));
                }
                cur = "";
            }
            else {
                cur += line[i];
            }
        }
        if (!cur.isEmpty()) rs.add(r[getIndex(cur)]);
        while(!ops.isEmpty()) {
            double d1 = rs.pop();
            double d2 = rs.pop();
            char c = ops.pop();
            rs.add(getREq(d1, d2, c));
        }

        double ans = rs.pop();
        out.printf("%.5f", ans);
        out.close();
    }
    static int getIndex(String R) {
        return Integer.parseInt(R.substring(1)) - 1;
    }
    static double getREq(double d1, double d2, char op) {
        if (op == '|') {
            return d1 * d2 / (d1 + d2);
        }
        return d1 + d2;
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
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}
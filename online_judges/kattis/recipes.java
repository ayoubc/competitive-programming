
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

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

        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<t;i++) {
            int R = in.nextInt();
            int P = in.nextInt();
            int D = in.nextInt();
            int I=0;
            String[] ing = new String[R];
            double[] w = new double[R];
            double[] p = new double[R];

            for(int j=0;j<R;j++){
                ing[j] = in.next();
                w[j] = in.nextDouble();
                p[j] = in.nextDouble();

                if(p[j]==100.0){
                    I = j;
                }
            }
            double sf = (double)D/(double)P;
            double sw = sf*w[I];
            sb.append("Recipe # " + (i+1) + "\n");

            for(int j=0;j<R;j++){
                if(j==I){
                    sb.append(ing[j] + " " + sw + "\n");

                }
                else{
                    sb.append(ing[j] + " " + sw*p[j]/100.0 + "\n");
                }
            }
            sb.append("----------------------------------------\n");
        }

        out.print(sb);
        out.close();
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
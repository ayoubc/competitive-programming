
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
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

        int n = in.nextInt();

        Edge[] parent = new Edge[n+1];
        double[] amount = new double[n+1];
        int[] K = new int[n+1];

        for(int i=0;i<n-1;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int x = in.nextInt();
            int k = in.nextInt();
            parent[v] = new Edge(u, x, k);
        }
        for(int i=1;i<=n;i++) K[i] = in.nextInt();

        for(int i=1;i<=n;i++){
            if(K[i]!=-1){
                amount[i] = K[i]*1.0;
            }
            else{
                amount[i] = 0.0;
            }
        }
        for(int i=1;i<=n;i++){
            if(K[i]!=-1) parse(i, parent, amount);
        }
        out.println(amount[1]);
        out.close();
    }
    static void parse(int a, Edge[] parent, double[] amount){
        if(a==1)
            return ;


        int par = parent[a].u;
        int x = parent[a].x;
        int k = parent[a].k;
        if(k==0){
            amount[par] = Math.max(amount[a]*100.0/x, amount[par]);
        }
        else if(k==1){
            amount[par] = Math.max(Math.sqrt(amount[a])*100.0/x, amount[par]);
        }
        parse(par, parent, amount);
    }
    static class Edge{
        public int u, x, k;

        public Edge(int u, int x, int k) {
            this.u = u;
            this.x = x;
            this.k = k;
        }
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
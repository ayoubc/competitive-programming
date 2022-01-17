
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static Pair[] a;
    static List<Pair> V;

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
        grid = new char[n][n];
        for (int i=0;i<n;i++) grid[i] = in.next().toCharArray();
        V = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!='.'){
                    V.add(new Pair(i,j));
                }
            }
        }
        Collections.sort(V);
        long  ans = 0;
        for(int i=0;i<V.size();i++){
            for(int j=i+1;j<V.size();j++){
                for(int k=j+1;k<V.size();k++){
                    if(sameLine(i,j,k)) ans++;
                }
            }
        }
//        StringBuilder sb = new StringBuilder();
//        for (int i=0;i<m;i++) sb.append(ans[i] + "\n");
        out.print(ans);
        out.close();
    }


    static class Pair implements Comparable {
        public int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair)o;
            if (i == p.i) {
                if (j < p.j) return -1;
                else if (j > p.j) return 1;
                return 0;
            }
            else if (i < p.i) return -1;
            return 1;
        }
    }

    static boolean sameLine(int i,int j,int k){
        return (V.get(j).i - V.get(i).i)*(V.get(k).j - V.get(i).j) - (V.get(k).i - V.get(i).i)*(V.get(j).j - V.get(i).j) == 0;
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
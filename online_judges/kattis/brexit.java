
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

        int c = in.nextInt();
        int p = in.nextInt();
        int x = in.nextInt();
        int l = in.nextInt();

        graph = new List[c+1];
        for (int i=0;i<=c;i++) graph[i] = new ArrayList<>();

        int[] pa = new int[c+1];
        int[] panow = new int[c+1];

        for (int i=0;i<p;i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            graph[a].add(b);
            graph[b].add(a);
            pa[a]++;
            panow[a]++;
            pa[b]++;
            panow[b]++;
        }
        String ans = "";
        if (x == l) {
            ans = "leave";
        }
        else {
            boolean leave = false;
            boolean[] vis = new boolean[c+1];

            Queue<Integer> q = new LinkedList<>();
            vis[l] = true;
            q.add(l);
            while(!q.isEmpty()){
                int v = q.poll();

                for(int i=0;i<graph[v].size();i++){
                    int u = graph[v].get(i), s;
                    if(!vis[u]){

                        panow[u]--;
                        if(panow[u] <= pa[u]/2){
                            if(u==x){
                                leave = true;
                                break;
                            }
                            else{
                                q.add(u);
                                vis[u] = true;
                            }
                        }
                    }

                }
            }
            ans = leave ? "leave" : "stay";
        }

        out.println(ans);
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
    }
}
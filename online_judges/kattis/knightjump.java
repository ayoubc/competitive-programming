package com.company;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int di[] = {2,2,-2,-2,1,1,-1,-1};
        int dj[] = {1,-1,1,-1,2,-2,2,-2};
        int n = in.nextInt();
        String[] chess = new String[n];
        int si = -1, sj = -1;
        for (int i= 0 ; i<n ;i++) {
            chess[i] = in.next();
            for(int j=0;j<n;j++) {
                if (chess[i].charAt(j) == 'K') {
                    si = i;
                    sj = j;
                }
            }
        }

        int[][] visited = new int[n][n];
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) visited[i][j] = -1;
        }
        Queue<Pair> q = new LinkedList<>();
        visited[si][sj] = 0;
        q.add(new Pair(si, sj));
        while(q.size() > 0) {
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            for(int k=0;k<di.length; k++) {
                int I = i + di[k];
                int J = j + dj[k];
                if (valid(I, J, n, visited, chess)){
                    visited[I][J] = visited[i][j] + 1;
                    q.add(new Pair(I, J));
                }
            }
        }
        out.println(visited[0][0]);
        out.close();
    }
    static class Pair {
        public int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static boolean valid(int i, int j, int n, int[][] vis, String[] chess) {
        return (i>=0) && (i<n) && (j>=0) && (j<n) && (vis[i][j] == -1) && (chess[i].charAt(j) != '#');
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

    }

}

import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);

        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) lines.add(line);
        out.println(part1(lines));
        out.close();
    }
    static char[][] readGrid(List<String> lines) {
        int n = lines.size();
        int m = lines.get(0).length();
        char[][] grid = new char[n][m];
        for (int i=0;i<n;i++) grid[i] = lines.get(i).toCharArray();
        return grid;
    }
    static long dijkstra(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) {
            dist[i][j] = Integer.MAX_VALUE;
        }
        PriorityQueue<Block> q = new PriorityQueue<>();
        q.add(new Block(0, 0, 0, '.', 0));
        dist[0][0] = 0;
        long ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Block cur = q.poll();
            //if (!cur.isValidS()) continue;
            //out.println(cur.i + " " + cur.j + " " + cur.cost);
            if (cur.i == n-1 && cur.j == m-1) {
                ans = Math.min(ans, cur.cost);
                //out.println(dist[n-1][m-1]);
                //ans = cur.cost;
                //break;
            }

            List<Block> nexts = cur.getNext(grid);
            for (Block b: nexts) {
                if (dist[b.i][b.j] > b.cost) {
                    dist[b.i][b.j] = b.cost;
                    q.add(b);
                }
            }
        }
        return ans;
    }
    static long part1(List<String> lines) {
        char[][] grid = readGrid(lines);
        return dijkstra(grid);
    }

    static long part2(List<String> lines) {
        long ans = 0;
        return ans;
    }
    static class Block implements Comparable<Block>{
        int i, j;
        char parentD;
        int scnt;
        int cost;
        public Block(int i, int j, int cost, char p, int s) {
            this.i = i;
            this.j = j;
            this.cost = cost;
            parentD = p;
            scnt = s;
        }
        public static int getNum(char c) {
            return c - '0';
        }
        public List<Block> getNext(char[][] grid) {
            List<Block> res = new ArrayList<>();
            int n = grid.length;
            int m = grid[0].length;
            if (!isValidS()) return res;
            if (parentD == '.') {
                if (isValid(i, j+1, n, m)) {
                    res.add(new Block(i, j+1, cost+getNum(grid[i][j+1]), '>', 1));
                }
                if (isValid(i+1, j, n, m)) {
                    res.add(new Block(i+1, j, cost+getNum(grid[i+1][j]), 'v', 1));
                }
            }
            if (parentD == '>') {
                if (isValid(i-1, j, n, m)) {
                    res.add(new Block(i-1, j, cost+getNum(grid[i-1][j]), '^', 1));
                }
                if (isValid(i+1, j, n, m)) {
                    res.add(new Block(i+1, j, cost+getNum(grid[i+1][j]), 'v', 1));
                }
                if (isValid(i, j+1, n, m)) {
                    res.add(new Block(i, j+1, cost+getNum(grid[i][j+1]), '>', scnt+1));
                }
            }
            if (parentD == '<') {
                if (isValid(i-1, j, n, m)) {
                    res.add(new Block(i-1, j, cost+getNum(grid[i-1][j]), '^', 1));
                }
                if (isValid(i+1, j, n, m)) {
                    res.add(new Block(i+1, j, cost+getNum(grid[i+1][j]), 'v', 1));
                }
                if (isValid(i, j-1, n, m)) {
                    res.add(new Block(i, j-1, cost+getNum(grid[i][j-1]), '<', scnt+1));
                }
            }
            // >, <, ^, v
            // 0, 1, 2, 3
            if (parentD == '^') {
                if (isValid(i, j+1, n, m)) {
                    res.add(new Block(i, j+1, cost+getNum(grid[i][j+1]), '>', 1));
                }
                if (isValid(i, j-1, n, m)) {
                    res.add(new Block(i, j-1, cost+getNum(grid[i][j-1]), '<', 1));
                }
                if (isValid(i-1, j, n, m)) {
                    res.add(new Block(i-1, j, cost+getNum(grid[i-1][j]), '^', scnt+1));
                }
            }
            if (parentD == 'v') {
                if (isValid(i, j-1, n, m)) {
                    res.add(new Block(i, j-1, cost+getNum(grid[i][j-1]), '<', 1));
                }
                if (isValid(i, j+1, n, m)) {
                    res.add(new Block(i, j+1, cost+getNum(grid[i][j+1]), '>', 1));
                }
                if (isValid(i+1, j, n, m)) {
                    res.add(new Block(i+1, j, cost+getNum(grid[i+1][j]), 'v', scnt+1));
                }
            }
            return res;
        }
        public boolean isValidS() {
            return scnt <= 4;
        }
        public boolean isValid(int i, int j, int n, int m) {
            return i>=0 && i<n && j>=0 && j<m;
        }
        @Override
        public int compareTo(Block o) {
            return Integer.compare(cost, o.cost);
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                return null;
            }
        }
    }
}
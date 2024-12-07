import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);
        List<Long> l1 = new ArrayList<>();
        List<Long> l2 = new ArrayList<>();
        while(true) {
            try{
                String[] line = in.readLine().split("\\s+");
                l1.add(Long.parseLong(line[0]));
                l2.add(Long.parseLong(line[1]));
            }
            catch (Exception e) {
                break;
            }
        }
        out.println(part2(l1, l2));
        out.close();
    }

    public static long part1(List<Long> l1, List<Long> l2) {
        Collections.sort(l1);
        Collections.sort(l2);
        long ans = 0;
        for(int i=0;i<l1.size();i++) ans += Math.abs(l1.get(i) - l2.get(i));
        return ans;
    }

    public static long part2(List<Long> l1, List<Long> l2) {
        Map<Long, Long> occ = new HashMap<>();
        for(long x:l2) occ.put(x, occ.getOrDefault(x, 0L)+1);
        long ans = 0L;
        for(long x:l1) ans += x * occ.getOrDefault(x, 0L);
        return ans;
    }
    static class P {
        int index, level;
        public P(int i, int l) {
            index = i;
            level = l;
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
        public double nextDouble() {return Double.parseDouble(next());}
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}

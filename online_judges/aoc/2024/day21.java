import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] arrows = {'>', 'v', '<', '^'};
    static char[][] directionsBoard = new char[][] {
            {'#', '^', 'A'},
            {'<', 'v', '>'}
    };
    static char[][] numericBoard = new char[][] {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'},
            {'#', '0', 'A'},
    };
    static Map<P, List<StringBuilder>> memo;
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;
    static boolean isPart2 = false;
    static char[][] grid;
    static int N;
    static int M;
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
        List<String> lines = new ArrayList<>();

        while (true) {
            try {
                String line = in.readLine();
                if (line == null) break;
                lines.add(line);
            } catch (Exception e) {
                break;
            }
        }

        out.println(part2(lines));
        out.close();
    }

    public static long part1(List<String> lines) {
        memo = new HashMap<>();
        long ans = 0;
        int times = isPart2 ? 25:2;
        for (String line : lines) {
            // we can break this to two consecutive chars, then go generate all after times times
            // then sum the min length of each
            List<Instruction> all = generateAll1(new StringBuilder(line), numericBoard, Integer.MAX_VALUE);

            long minLength = Long.MAX_VALUE;
            for(int i=1;i<=times;i++) {
                List<Instruction> cur = new ArrayList<>();
                long curLimit = Long.MAX_VALUE;
                for(Instruction inst:all) {
                    List<Instruction> tmp = generateAll2(inst, directionsBoard, curLimit);
                    for(Instruction sb2:tmp) {
                        curLimit = Math.min(curLimit, sb2.len);
                        cur.add(sb2);
                    }
                }
                if (i==times) minLength = Math.min(minLength, curLimit);
                long minL = curLimit;
                all = cur.stream().filter(s -> s.len==minL).toList();
                System.out.println(all.size());
            }
            System.out.println("min length: "+minLength);
            ans += minLength * Integer.parseInt(line.substring(0, line.length()-1));
        }
        return ans; // 162740
    }

    public static List<StringBuilder> bfs(Point s, Point e, char[][] board) {
        P p = new P(s.i, s.j, e.i, e.j);
        if (memo.containsKey(p)) return memo.get(p);
        int n = board.length;
        int m = board[0].length;

        Queue<PPP> q = new LinkedList<>();
        PPP ppp = new PPP(s, new StringBuilder(), new HashSet<>());
        ppp.steps.add(s);
        q.add(ppp);
        List<StringBuilder> res = new ArrayList<>();
        int shortest = directPath(s, e, board).length();
        while (!q.isEmpty()) {
            PPP cur = q.poll();
            if (cur.p.i == e.i && cur.p.j == e.j) {
                res.add(cur.path.append('A'));
            }
            for (int k = 0; k < 4; k++) {
                int ii = dx[k] + cur.p.i;
                int jj = dy[k] + cur.p.j;
                if (ii < 0 || ii >= n || jj < 0 || jj >= m || board[ii][jj] == '#') continue;
                Point nxt = new Point(ii, jj);

                if (!cur.steps.contains(nxt) && cur.path.length() < shortest) {
                    StringBuilder path = new StringBuilder(cur.path);
                    Set<Point> steps = new HashSet<>(cur.steps);
                    steps.add(nxt);
                    path.append(arrows[k]);
                    q.add(new PPP(nxt, path, steps));
                }
            }
        }
        memo.put(p, res);
        return res;
    }

    public static List<Instruction> generateAll1(StringBuilder line, char[][] board, int limit) {
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction(new HashMap<>(), 0, '#', ""));


        for(int i=0;i<line.length();i++) {
            List<StringBuilder> tmp = new ArrayList<>();
            if (i == 0)
                tmp = bfs(getPoint('A', board), getPoint(line.charAt(i), board), board);
            else
                tmp = bfs(getPoint(line.charAt(i-1), board), getPoint(line.charAt(i), board), board);

            int l = tmp.get(0).length();
            List<Instruction> cur = new ArrayList<>();
            for(Instruction inst : instructions) {
                if (inst.len + l > limit) continue;
                for(StringBuilder chunk:tmp) {
                    Instruction sb2 = new Instruction(inst);
                    for(int j=0;j<chunk.length();j++) {
                        String cons = null;
                        if (j == 0) {
                            if (sb2.len > 0) {
                                cons = sb2.last+chunk.charAt(j);
                            }
                            else {
                                sb2.first = chunk.charAt(j);
                            }
                        }
                        else {
                            cons = chunk.substring(j-1, j+1);
                        }
                        if(cons != null) {
                            sb2.comp.put(cons, sb2.comp.getOrDefault(cons, 0L) + 1);
                        }
                        sb2.len += 1;
                        if (j == chunk.length()-1) sb2.last = chunk.substring(j, j+1);
                    }
                    cur.add(sb2);
                }
            }
            instructions = cur;

        }
        long len = instructions.stream().map(Instruction::getLen).min(Long::compare).orElse(0L);

        return instructions.stream().filter(s -> s.getLen() == len).toList();
    }
    public static List<Instruction> generateAll2(Instruction inst, char[][] board, long limit) {
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction(new HashMap<>(), 0, '#', ""));


        Iterator<String> iterator = inst.comp.keySet().iterator();
        int cnt = 0;
        while (iterator.hasNext()) {
            List<StringBuilder> tmp = new ArrayList<>();
            long count = 1;
            if (cnt == 0) {
                cnt++;
                tmp = bfs(getPoint('A', board), getPoint(inst.first, board), board);
            }
            else {
                String line = iterator.next();
                count = inst.comp.get(line);
                tmp = bfs(getPoint(line.charAt(0), board), getPoint(line.charAt(1), board), board);
            }

            int l = tmp.get(0).length();
            List<Instruction> cur = new ArrayList<>();
            for(Instruction oldInst : instructions) {
                if (oldInst.len + l > limit) continue;
                for(StringBuilder chunk:tmp) {
                    Instruction sb2 = new Instruction(oldInst);
                    for(int j=0;j<chunk.length();j++) {
                        String cons = null;
                        if (j == 0) {
                            if (sb2.len > 0) {
                                cons = sb2.last+chunk.charAt(j);
                            }
                            else {
                                sb2.first = chunk.charAt(j);
                            }
                        }
                        else {
                            cons = chunk.substring(j-1, j+1);
                        }
                        if(cons != null) {
                            sb2.comp.put(cons, sb2.comp.getOrDefault(cons, 0L) + count);
                        }
                        sb2.len += count;
                        if (j == chunk.length()-1) sb2.last = chunk.substring(j, j+1);
                    }
                    cur.add(sb2);
                }
            }
            instructions = cur;
        }

        long len = instructions.stream().map(Instruction::getLen).min(Long::compare).orElse(0L);
        return instructions.stream().filter(s -> s.getLen() == len).toList();
    }
    public static StringBuilder directPath(Point s, Point e, char[][] board) {
        StringBuilder res = new StringBuilder();
        String horizontal = s.j - e.j > 0 ? "<".repeat(s.j - e.j) : ">".repeat(e.j - s.j);
        if (s.i >= e.i) {
            res.append("^".repeat(s.i - e.i));
            res.append(horizontal);
        }
        else if (s.i < e.i) {
            res.append(horizontal);
            res.append("v".repeat(e.i - s.i));
        }
        return res.append('A');
    }

    public static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines); // 203640915832208
    }

    public static Point getPoint(char c, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c) return new Point(i, j);
            }
        }
        return null;
    }

    record Point(int i, int j) {}
    record State(Point p, StringBuilder path) { }
    record PP(Point p, int steps) { }
    record P(int si, int sj, int ei, int ej) { }
    record PPP(Point p, StringBuilder path, Set<Point> steps) { }

    // compressed instructions
    //record Instruction(Map<String, Integer> comp, int len, String last) {}

    static class Instruction {
        Map<String, Long> comp;
        long len;
        String last;
        char first;
        Instruction(Map<String, Long> comp, long len, char first, String last) {
            this.comp = comp;
            this.len = len;
            this.last = last;
            this.first = first;
        }

        Instruction(Instruction o) {
            this.comp = new HashMap<>();
            for(String k : o.comp.keySet()) {
                this.comp.put(k, o.comp.get(k));
            }
            this.len = o.len;
            this.last = o.last;
            this.first = o.first;
        }

        public long getLen() {
            return len;
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String readLine() throws IOException {
            return reader.readLine();
        }
    }
}
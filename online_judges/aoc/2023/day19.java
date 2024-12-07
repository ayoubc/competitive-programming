import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;
    static int seek = 0;

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
        out.println(part2(lines));
        out.close();
    }

    static private Map<String, String[]> readWorkFlows(List<String> lines) {
        Map<String, String[]> res = new HashMap<>();
        for (String line : lines) {
            seek++;
            if (line.isEmpty()) break;
            String[] parts = line.split("[{}]");
            res.put(parts[0], parts[1].split(","));
        }
        return res;
    }

    static boolean isAccepted(Part part, String workflow, Map<String, String[]> workflows) {
        if (workflow.equals("A")) return true;
        if (workflow.equals("R")) return false;

        String[] predicates = workflows.get(workflow);
        boolean ok = true;
        for (String predicate : predicates) {
            String[] tmp = predicate.split(":");
            if (tmp.length == 2) {
                if (isTrue(part, tmp[0])) {
                    ok &= isAccepted(part, tmp[1], workflows);
                    break;
                }
            } else ok &= isAccepted(part, tmp[0], workflows);
        }
        return ok;
    }

    static boolean isTrue(Part part, String predicate) {
        long value = part.getValue(predicate.charAt(0));
        char opt = predicate.charAt(1);
        long num = Long.valueOf(predicate.substring(2));
        if (opt == '>') return value > num;
        return value < num;
    }

    static class Part {
        Map<Character, Long> mp = new HashMap<>();
        Map<Character, Interval> imp = new HashMap<>();
        public Part() {
            // {x=787,m=2655,a=1222,s=2876}
            imp.put('x', new Interval());
            imp.put('m', new Interval());
            imp.put('a', new Interval());
            imp.put('s', new Interval());
        }
        public Part(Part part) {
            imp = new HashMap<>();
            for (Map.Entry<Character, Interval> entry: part.imp.entrySet()) {
                imp.put(entry.getKey(), new Interval(entry.getValue()));
            }
            mp = new HashMap<>(part.mp);
        }
        public Part(String line) {
            String[] parts = line.split(",");
            for (String p : parts) {
                mp.put(p.charAt(0), Long.valueOf(p.substring(2)));
            }
        }

        public long getSum() {
            long res = 0;
            for (Long l : mp.values()) res += l;
            return res;
        }

        public long getValue(char c) {
            return mp.get(c);
        }
        public Interval getInterval(char c) {
            return imp.get(c);
        }
        public void setInterval(char c, Interval intv) {
            imp.put(c, intv);
        }
        public void setValue(char c, long v) {
            mp.put(c, v);
        }
        public long countCombinations() {
            long p = 1L;
            for (Interval intv : imp.values()) p *= intv.count();
            return p;
        }
    }

    static List<Part> readParts(List<String> lines) {
        List<Part> res = new ArrayList<>();
        while (seek < lines.size()) {
            String line = lines.get(seek);
            res.add(new Part(line.substring(1, line.length() - 1)));
            seek++;
        }
        return res;
    }

    static long part1(List<String> lines) {
        seek = 0;
        Map<String, String[]> workflows = readWorkFlows(lines);
        List<Part> parts = readParts(lines);
        long ans = 0;
        for (Part part : parts) {
            if (isAccepted(part, "in", workflows)) {
                ans += part.getSum();
            }
        }
        return ans; // 373302
    }
    static Part updateIntervals(String predicate, Part part) {
        char attr = predicate.charAt(0);
        char opt = predicate.charAt(1);
        long num = Long.parseLong(predicate.substring(2));
        Part newP = new Part(part);
        Interval intv = part.getInterval(attr);
        Interval newIintv = newP.getInterval(attr);
        if (opt == '>') {
            intv.setR(num);
            newIintv.setL(num+1);
        }
        else {
            intv.setL(num);
            newIintv.setR(num-1);
        }
        part.setInterval(attr, new Interval(intv));
        newP.setInterval(attr, newIintv);
        return newP;
    }

    static long countAccepted(String workflow, Map<String, String[]> workflows, Part part) {
        if (workflow.equals("A")) return part.countCombinations();
        if (workflow.equals("R")) return 0L;

        String[] predicates = workflows.get(workflow);
        long res = 0L;
        for (String predicate : predicates) {
            String[] tmp = predicate.split(":");
            if (tmp.length == 2) {
                Part newP = updateIntervals(tmp[0], part);
                res += countAccepted(tmp[1], workflows, newP);
            } else res += countAccepted(tmp[0], workflows, new Part(part));
        }
        return res;
    }

    static long part2(List<String> lines) {
        seek = 0;
        Map<String, String[]> workflows = readWorkFlows(lines);
        return countAccepted("in", workflows, new Part()); // 130262715574114
    }
    static class Interval {
        long l, r;
        public Interval() {
            l = 1L;
            r = 4000L;
        }
        public Interval(Interval intv) {
            this(intv.l, intv.r);
        }
        public Interval(long left, long right) {
            l = left;
            r = right;
        }
        public void setL(long v) {
            l = v;
        }
        public void setR(long v) {
            r = v;
        }
        public long count() {
            return Math.max(0L, r - l + 1L);
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
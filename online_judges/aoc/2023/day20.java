import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static InputReader in;
    static PrintWriter out;
    static boolean isPart2;

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

    static class Module {
        char type; // %, &, b
        String name;
        Map<String, Character> inputPulse; // l or h;
        String[] subs;
        public Module(char type, String name, String list) {
            this.type = type;
            this.name = name;
            subs = list.split(", ");
            inputPulse = new HashMap<>();
        }
        public static Module createModule(char t, String name, String list) {
            if (t == '%') return new FlipFlop(name, list);
            else if (t == '&') return new Conjunction(name, list);
            return new Module(t, name, list);
        }
        public int[] sendPulses(Map<String, Module> modules, Queue<Pulse> q, char curPulse) {
            int[] res = {0, 0};
            char outPulse = getOutPulse();
            for (String name: subs) {
                q.add(new Pulse(outPulse, this.name, name));
            }
            res[0] = outPulse == 'l' ? subs.length : 0;
            res[1] = outPulse == 'h' ? subs.length : 0;
            return res;
        }
        public void setInputPulse(char inP, String name) {
            inputPulse.put(name, inP);
        }
        public char getOutPulse() {
            return 'l';
        }
        public boolean isConjunction() {
            return type == '&';
        }
    }
    static class FlipFlop extends Module {
        boolean on;
        public FlipFlop(String name, String list) {
            super('%', name, list);
            on = false;
        }
        @Override
        public int[] sendPulses(Map<String, Module> modules, Queue<Pulse> q, char curPulse) {
            if (curPulse == 'h') return new int[]{0, 0};
            toggle();
            return super.sendPulses(modules, q, curPulse);
        }
        @Override
        public char getOutPulse() {
            return on ? 'h' : 'l';
        }
        public void toggle() {
            on = !on;
        }
    }
    static class Conjunction extends Module {
        List<String> pubs;
        public Conjunction(String name, String list) {
            super('&', name, list);
            pubs = new ArrayList<>();
        }
        public void addPub(String name) {
            pubs.add(name);
        }
        @Override
        public char getOutPulse() {
            for (String pub: pubs) {
                char p = inputPulse.getOrDefault(pub, 'l');
                if (p == 'l') return 'h';
            }
            return 'l';
        }
    }
    static class Pulse {
        char type;
        String from;
        String to;
        public Pulse(char type, String f, String t) {
            this.type = type;
            from = f;
            to = t;
        }
    }
    static Map<String, Module> readModules(List<String> lines) {
        Map<String, Module> res = new HashMap<>();
        for (String line: lines) {
            String[] tmp = line.split(" -> ");
            char type = tmp[0].charAt(0);
            if (type == '%' || type == '&') tmp[0] = tmp[0].substring(1);
            res.put(tmp[0], Module.createModule(type, tmp[0], tmp[1]));
        }
        // update input of conjunctions
        for (String name: res.keySet()) {
            Module m = res.get(name);
            for (String sub: m.subs) {
                Module subM = res.get(sub);
                if (subM != null && subM.isConjunction()) {
                    Conjunction conM = (Conjunction) subM;
                    conM.addPub(name);
                }
            }
        }
        return res;
    }

    static long part1(List<String> lines) {
        Map<String, Module> modules = readModules(lines);
        long l = 0L;
        long h = 0L;
        for (int i=0;i<1000;i++) {
            Queue<Pulse> q = new LinkedList<>();
            l += 1;
            q.add(new Pulse('l', "button", "broadcaster"));
            while (!q.isEmpty()) {
                Pulse p = q.poll();
                Module m = modules.get(p.to);
                if (m == null) continue;
                m.setInputPulse(p.type, p.from);

                int[] res = m.sendPulses(modules, q, p.type);
                l += res[0];
                h += res[1];
            }
        }
        return l * h;
    }

    static long part2(List<String> lines) {
        isPart2 = true;
        return part1(lines);
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
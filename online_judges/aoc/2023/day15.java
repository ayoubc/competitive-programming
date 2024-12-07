import java.io.*;
import java.util.*;


public class Main {
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
        out.println(part2(lines));
        out.close();
    }
    static int hash(String s) {
        int res = 0;
        for (int i=0;i<s.length();i++) {
            res += s.charAt(i);
            res = (res * 17) % 256;
        }
        return res;
    }
    static long part1(List<String> lines) {
        long ans = 0;
        String[] steps = lines.get(0).split(",");
        for (String s: steps){
            ans += hash(s);
        }
        return ans;
    }

    static long part2(List<String> lines) {
        String[] steps = lines.get(0).split(",");
        List<String>[] boxes = new List[256];
        for (int i=0;i<256;i++) boxes[i] = new ArrayList();
        for (String s: steps){
            if (s.endsWith("-")) {
                String tmp = s.substring(0, s.length()-1);
                int h = hash(tmp);
                int idx = -1;
                for(int i=0;i<boxes[h].size();i++) {
                    String str = boxes[h].get(i);
                    if(tmp.equals(str.substring(0, str.length()-2))) {
                        idx = i;
                        break;
                    }
                }
                if (idx != -1) boxes[h].remove(idx);
            }
            else {
                String tmp = s.substring(0, s.length()-2);
                int h = hash(tmp);
                int idx = -1;
                for(int i=0;i<boxes[h].size();i++) {
                    String str = boxes[h].get(i);
                    if(tmp.equals(str.substring(0, str.length()-2))) {
                        idx = i;
                        break;
                    }
                }
                if (idx != -1) boxes[h].set(idx, s);
                else boxes[h].add(s);
            }
        }
        long ans = 0;
        for (int i=0;i<256;i++) {
            for (int j=0;j<boxes[i].size();j++) {
                String s = boxes[i].get(j);
                ans += (i+1) * (j+1) * (s.charAt(s.length()-1)-'0');
            }
        }
        return ans;
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
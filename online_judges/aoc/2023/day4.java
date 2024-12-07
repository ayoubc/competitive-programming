import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) lines.add(line);

        out.println(part2(lines));
        out.close();
    }

    private static long part1(List<String> lines) {
        long ans = 0;
        for (String line: lines) {
            int cnt = 0;
            Set<String> winning = new HashSet<>();
            String[] nums = line.split("\\s+");
            int i = 2;
            while (nums[i].charAt(0) != '|') winning.add(nums[i++]);
            while (i < nums.length) {
                if (winning.contains(nums[i++])) cnt++;
            }
            ans += (cnt == 0 ? 0 : (1L << (cnt - 1)));
        }

        return ans;
    }

    private static long part2(List<String> lines) {
        int[] occ = new int[lines.size()];
        Arrays.fill(occ, 1);
        for (int i=0;i<lines.size();i++) {
            String line = lines.get(i);
            int cnt = 0;
            Set<String> winning = new HashSet<>();
            String[] nums = line.split("\\s+");
            int j = 2;
            while (nums[j].charAt(0) != '|') winning.add(nums[j++]);
            while (j < nums.length) {
                if (winning.contains(nums[j++])) cnt++;
            }
            for (int k=1;k<=Math.min(cnt, lines.size()-i-1);k++) occ[i+k] += occ[i];
        }
        long ans = 0;
        for (int i=0;i<occ.length;i++) ans += occ[i];

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

import java.io.*;
import java.util.*;


public class Main {

    static Map<String, Integer> config = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14
    );
    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        long ans = 0;
        String line = null;
        while ((line = in.readLine()) != null) {
            ans += part2(line);
        }
        out.println(ans);
        out.close();
    }

    static int part1(String s) {
        String[] arr = s.split(" ");
        int gameId = Integer.valueOf(arr[1].substring(0, arr[1].length()-1));
        for(int i=2;i<arr.length;i+=2) {
            int val = Integer.valueOf(arr[i]);
            String color = i+1 == arr.length - 1 ? arr[i+1] : arr[i+1].substring(0, arr[i+1].length()-1);
            if (config.get(color) < val) {
                return 0;
            }
        }
        return gameId;
    }

    static long part2(String s) {
        String[] arr = s.split(" ");
        Map<String, Integer> set = new HashMap<>();
        for(int i=2;i<arr.length;i+=2) {
            int val = Integer.valueOf(arr[i]);
            String color = i+1 == arr.length - 1 ? arr[i+1] : arr[i+1].substring(0, arr[i+1].length()-1);
            int prev = set.getOrDefault(color, 0);
            set.put(color, Math.max(val, prev));
        }
        long res = 1;
        for(Integer d : set.values()) res *= d;
        return res;
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

import java.io.*;
import java.util.*;


public class Main {

    static Map<String, Character> wordToInt = Map.of(
            "one", '1',
            "two", '2',
            "three", '3',
            "four", '4',
            "five", '5',
            "six", '6',
            "seven", '7',
            "eight", '8',
            "nine", '9'
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

        int ans = 0;
        while (true) {
            try {
                ans += part2(in.next());
            } catch (RuntimeException ex) {
                break;
            }
        }
        out.println(ans);
        out.close();
    }

    static int part1(String s) {
        String x = "";
        char last = '0';
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (x.length() == 0) x += c;
                last = c;
            }
        }
        x += last;
        return Integer.valueOf(x);
    }

    static int part2(String s) {
        String x = "";
        char last = '0';
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (x.length() == 0) x += c;
                last = c;
            }
            else {
                String word = "";
                for(int j=i;j<s.length();j++) {
                    if (word.length() >= 6) break;
                    word += s.charAt(j);
                    if (wordToInt.containsKey(word)) {
                        if (x.length() == 0) x += wordToInt.get(word);
                        last = wordToInt.get(word);
                        break;
                    }
                }
            }

        }
        x += last;
        return Integer.valueOf(x);
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String readLine() throws IOException{
            return reader.readLine();
        }
    }
}

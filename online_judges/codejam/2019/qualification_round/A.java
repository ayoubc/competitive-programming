import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.nextInt();
        for (int tt=1;tt<=t;tt++) {
            String N = in.next();
            String A = "", B = "";
            for(int i=0;i<N.length();i++) {
                if (N.charAt(i) == '4') {
                    A += '2';
                    B += '2';
                }
                else {
                    A += N.charAt(i);
                    B += '0';
                }
            }
            int i=0;
            while(B.charAt(i) == '0') i++;
            out.println("Case #" + tt + ": " + A + " " + B.substring(i));
        }
        out.close();

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

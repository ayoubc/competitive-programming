
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        String[] days = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] str1 = in.next().split(":");
        String[] str2 = in.next().split(":");
        String[] inter1 = in.next().split(":");
        String[] inter2 = in.next().split(":");

        int x1 = Integer.parseInt(str1[0]) * 60 + Integer.parseInt(str1[1]);
        int y1 = Integer.parseInt(inter1[0]) * 60 + Integer.parseInt(inter1[1]);
        int x2 = Integer.parseInt(str2[0]) * 60 + Integer.parseInt(str2[1]);
        int y2 = Integer.parseInt(inter2[0]) * 60 + Integer.parseInt(inter2[1]);
        int d = gcd(y1, y2);
        String ans;
        if( (x1 - x2) % d != 0) ans = "Never";
        else {
            int k2 = 0;
            int cur = k2 * y2;
            int diff = x1 - x2;
            while((cur - diff) % y1 !=0) {
                k2++;
                cur =  k2 * y2;
            }
            int m = k2 * y2 + x2;
            ans = days[(m / (24 * 60)) % 7];
            //out.println(m);
            String hours = Integer.toString((m%(24 * 60)) / 60);
            String minutes = Integer.toString((m%(24 * 60))%60);

            if (hours.length() <=1 ) hours  = "0" + hours;
            if (minutes.length() <= 1) minutes = "0" + minutes;

            ans += "\n" + hours + ":" + minutes;
        }
        out.println(ans);
        out.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static  int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
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

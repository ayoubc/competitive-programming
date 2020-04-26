
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.nextInt();

        for (int tt=1;tt<=t;tt++) {
            int N = in.nextInt();
            int L = in.nextInt();
            BigInteger[] l = new BigInteger[L];
            BigInteger[] ans = new BigInteger[L+1];
            for (int i=0;i < L; i++) {
                l[i] = new BigInteger(in.next());
            }
            HashSet<BigInteger> primes = new HashSet<>();
            int i = 0;
            while (i<L && l[i].equals(l[0])) i++;
            BigInteger val = gcd(l[0], l[i]);
            if(i % 2 == 0) {
                ans[i] = val;
                ans[0] = val;
                ans[i+1] = l[i].divide(val);
                ans[1] = l[0].divide(val);
            }
            else{
                ans[i] = val;
                ans[1] = val;
                ans[0] = l[0].divide(val);
                ans[i+1] = l[i].divide(val);;
            }
            primes.add(ans[0]);
            primes.add(ans[1]);
            primes.add(ans[i]);
            primes.add(ans[i+1]);
            for(int k=0; k < i; k++) {
                if (k % 2 == 0) ans[k] = ans[0];
                else ans[k] = ans[1];
            }
            for(int k=i+1; k < L; k++) {
                ans[k+1] = l[k].divide(ans[k]);
                primes.add(ans[k+1]);
            }
            List<BigInteger> P = new ArrayList<>();
            for (BigInteger d: primes) P.add(d);
            Collections.sort(P);

            String text = "";

            for(int j=0; j<=L; j++) {
                int index = 0;
                for (int k=0;k<26;k++) {
                    if (P.get(k).equals(ans[j])) {
                        index = k;
                        break;
                    }
                }
                text += (char) ('A' + index);
            }

            out.println("Case #" + tt + ": " + text);
        }
        out.close();

    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) return a;
        return gcd(b, a.mod(b));
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


import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;


    public static void main(String[] args){
        InputStream is;
        try {
            is = new FileInputStream(".\\src\\in.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = in.nextInt();
            P[] H = new P[n];
            int lmax = 0;
            for (int i=0;i<n;i++) {
                String name = in.next();
                name = name.substring(0, name.length()-1);
                String clas = in.next();
                String str = in.next();
                String s = "";
                String[] parts = clas.split("-");
                for (String part: parts) {
                    if(part.equals("upper")) s += "3";
                    else if (part.equals("middle")) s += "2";
                    else s += "1";
                }
                lmax = Math.max(lmax, s.length());
                H[i] = new P(name, s);
            }

            for(int i=0;i<n;i++){
                String s = H[i].clas;
                s = reverse(s);
                int sz = s.length();
                for(int j=1;j<=lmax-sz;j++){
                    s += "2";
                }
                H[i].clas = s;
            }
            Arrays.sort(H);
            for(int i=n-1;i>=0;i--) sb.append(H[i].name + "\n");
            sb.append("==============================\n");
        }

        out.print(sb);
        out.close();
    }

    static class P implements Comparable{
        public String name, clas;

        public P(String name, String clas) {
            this.name = name;
            this.clas = clas;
        }

        @Override
        public int compareTo(Object o) {
            P p  = (P)o;
            if (clas.equals(p.clas)) {
                return name.compareTo(p.name) * -1;
            }
            return clas.compareTo(p.clas);
        }
    }
    static String reverse(String s){
        String S = "";
        for(int i=s.length()-1;i>=0;i--){
            S+=s.charAt(i);
        }
        return S;
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
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {return Double.parseDouble(next());}
    }
}
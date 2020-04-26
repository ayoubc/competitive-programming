package com.company;


import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        BigInteger[] C = new BigInteger[n + 1];
        C[0] = BigInteger.ONE;
        for (int i=1;i<=n;i++) {
            BigInteger a = BigInteger.valueOf(2 * (2 * (i - 1) + 1));
            BigInteger b = BigInteger.valueOf(i + 1);

            C[i] = a.multiply(C[i - 1]).divide(b);
        }

        BigInteger ans = BigInteger.ZERO;
        for(int i=0;i<=n;i++) {
            ans = ans.add(C[i].multiply(C[n - i]));

        }
        out.println(ans);
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

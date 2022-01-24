import java.io.*;
import java.util.*;


public class P12 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i=0;i<n;i++) a[i] = in.nextInt();

        int i=0;
        while (i + 1 < n && a[i] < a[i+1]) i++;

        int j = i;
        while (j + 1 < n && a[j] > a[j+1]) j++;

        reverse(a, i, j);
        boolean ok = true;
        for (int k=0;k<n-1; k++) {
            ok &= (a[k] < a[k+1]);
        }
        //for (int k=0;k<n;k++) out.print(a[k] + (k < n-1 ? " ": "\n"));
        if(ok) {
            out.println("yes");
            i++;
            j++;
            out.print(i + " " + j);
        }
        else out.print("no");

        out.close();

    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void reverse(int[] arr, int i, int j) {
        int n = j - i + 1;
        for (int k=0;k<n/2;k++) swap(arr, k+i, n-1-k+i);
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
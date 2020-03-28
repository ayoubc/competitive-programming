package com.company;



import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line;
        int tc = 0;
        while (sc.hasNextLine()){
            line = sc.nextLine();
            if (line.equals("")) break;
            String[] arr = line.split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = 1000000, M = -1000000 ;
            for(int i=1; i <= n; i++) {
                m = Math.min(m, Integer.parseInt(arr[i]));
                M = Math.max(M, Integer.parseInt(arr[i]));
            }

            System.out.println("Case " + (++tc) + ": " + m + " " + M + " " + (M - m));
        }

    }


}

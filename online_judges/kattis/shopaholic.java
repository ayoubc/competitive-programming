package com.company;


import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] items = new int[n];
        for(int i=0;i<n;i++){
            items[i] = sc.nextInt();
        }
        Arrays.sort(items);
        long ans = 0;
        for (int i=n-1;i>=0;i--){
            //System.out.println(items[i]);
            ans += ((n - 1 - i) % 3 == 2 ? items[i] : 0);
        }
        System.out.print(ans);
    }
}

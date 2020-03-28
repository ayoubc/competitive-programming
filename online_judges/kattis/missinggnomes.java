package com.company;



import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[m];

        int[] remain = new int[n+1];
        for (int i=0;i<m;i++) {
            arr[i] = sc.nextInt();
            remain[arr[i]] = 1;
        }
        ArrayList<Integer> hiden = new ArrayList<Integer>();
        for (int i=1;i<=n;i++){
            if (remain[i] != 1) hiden.add(i);
        }
        int i=0,j=0;
        while(i < hiden.size() || j < m){
            int ans;
            if (i < hiden.size() && j < m) {
                if (hiden.get(i) < arr[j]) {
                    ans = hiden.get(i);
                    i++;
                }
                else {
                    ans = arr[j];
                    j++;
                }

            }
            else if (i < hiden.size()) {
                ans = hiden.get(i);
                i++;
            }
            else{
                ans = arr[j];
                j++;
            }

            System.out.println(ans);
        }
    }


}

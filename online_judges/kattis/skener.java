package com.company;



import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r,c, zr, zc;
        r = sc.nextInt();
        c = sc.nextInt();
        zr = sc.nextInt();
        zc = sc.nextInt();

        String[] matrix = new String[r];
        for(int i=0;i<r;i++){
            matrix[i] = sc.next();
        }

        String[] ans = new String[r * zr];
        for(int i=0; i<r*zr;i++){
            ans[i] = "";
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                String str = "";
                for (int k=0;k<zc;k++){
                    str += matrix[i].charAt(j);
                }

                for (int k=0;k<zr;k++){
                    ans[i * zr + k] += str;
                }
            }

        }
        for(int i=0; i<r*zr;i++){
            System.out.println(ans[i]);
        }
    }
}

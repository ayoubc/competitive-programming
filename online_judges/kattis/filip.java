package com.company;



import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A,B;
        A = sc.next();
        B = sc.next();

        A = reverse(A);
        B = reverse(B);


        String ans = (A.compareTo(B) < 0 ? B : A);
        System.out.println(ans);
    }

    public static  String reverse(String str){
        String ans = "";
        for(int i=str.length()-1; i>=0; i--){
            ans += str.charAt(i);
        }
        //System.out.println(ans);
        return  ans;
    }

}

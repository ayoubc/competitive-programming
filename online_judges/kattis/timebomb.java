package com.company;



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numbers = {
                "***   * *** *** * * *** *** *** *** ***",
                "* *   *   *   * * * *   *     * * * * *",
                "* *   * *** *** *** *** ***   * *** ***",
                "* *   * *     *   *   * * *   * * *   *",
                "***   * *** ***   * *** ***   * *** ***"
        };

        String[] bomb = new String[5];
        for (int i=0; i<5; i++) {
            bomb[i] = sc.nextLine();
        }
        boolean con = true;
        String total = "";
        for (int i=0; i<bomb[0].length()-2;i+=4) {
            int d = getNumber(bomb, i, numbers);
            if (d == -1) {
                //System.out.println("Boom index " + i);
                con = false;
                break;
            }
            //System.out.println(d);
            total += Integer.toString(d);
        }
        if (con) {
            int n = Integer.parseInt(total);
            //System.out.println(total);
            if(n % 6 == 0) System.out.println("BEER!!");
            else System.out.println("BOOM!!");
        }
        else System.out.println("BOOM!!");
    }

    public static int getNumber(String[] bomb, int index, String[] numbers) {
        int ans = -1;
        for (int i=0; i<numbers[0].length() - 2; i+=4){
            boolean ok = true;
            for (int k=0;k<3; k++){
                for (int j=0;j < 5; j++){
                    if (numbers[j].charAt(i+k) != bomb[j].charAt(index+k)){
                        ok = false;
                        break;
                    }
                }
                if (!ok) break;
            }
            if (ok) {
                ans = i/4;
                break;
            }
        }
        return ans;
    }

}

package com.company;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (sc.hasNextLine()) {
            n = sc.nextInt();
            if (n == 0) break;
            HashMap<String, ArrayList<String>> hp= new HashMap<String, ArrayList<String>>();
            sc.nextLine();
            for(int i=0; i<n ;i++){
                String line = sc.nextLine();
                String[] arr =  line.split(" ");

                for (int j=1;j < arr.length; j++){

                    ArrayList<String> tmp = hp.get(arr[j]);

                    if(tmp == null){
                       tmp = new ArrayList<String>();
                    }
                    tmp.add(arr[0]);
                    hp.put(arr[j], tmp);
                }
            }
            ArrayList<String> keys = new ArrayList<String>();
            for(String key: hp.keySet()){
                //System.out.print(key);
                keys.add(key);
                Collections.sort(hp.get(key));
            }
            Collections.sort(keys);
            for(String key: keys){
                System.out.print(key);
                for(String person : hp.get(key)) {
                    System.out.print(" " + person);
                }
                System.out.println();
            }
            System.out.println();
        }
    }


}

package com.company;



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> arr = new ArrayList<String>();
        String line;
        while (sc.hasNextLine()){
            line = sc.nextLine();
            //System.out.println(line);
            if (line.equals("")) break;
            String[] tmp = line.split(" ");
            for(String str : tmp){
                arr.add(str);
            }

        }
        HashSet<String> st = new HashSet<String>();
        for(int i=0;i<arr.size(); i++) {
            for(int j=0; j<arr.size(); j++) {
                if (i != j) {
                    st.add(arr.get(i)+arr.get(j));
                }
            }
        }
        Object[] ans = st.toArray();
        Arrays.sort(ans);
        for (Object str : ans){
            System.out.println(str);
        }
    }

}

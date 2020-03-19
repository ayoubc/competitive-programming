package com.company;
import java.util.*;
public class DownTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] v = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<n;i++) {
            v[i] = sc.nextInt();
        }
        Arrays.sort(v);

        int cnt=1;

        for(int i=0;i<n;i++) {

            while(q.size() > 0){
                int x = q.peek();
                if(v[i] - x >= 1000) q.remove();
                else break;
            }

            q.add(v[i]);
            int need = q.size() / k + (q.size()%k ==0 ? 0 : 1 );

            if(need > cnt) cnt++;
        }

        System.out.println(cnt);
    }
}


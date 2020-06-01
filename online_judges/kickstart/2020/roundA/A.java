
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int t = sc.nextInt();
        for(int tc=1;tc<=t;tc++){
            ans.append("Case #"+tc+": ");

            int n = sc.nextInt();
            int b = sc.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++) a[i] = sc.nextInt();

            int cnt = 0;
            int price = 0;
            Arrays.sort(a);
            for(int p: a) {
                if (price + p <= b) {
                    price += p;
                    cnt++;
                }
            }
            ans.append(cnt+"\n");
        }

        System.out.println(ans);
        sc.close();

    }

}

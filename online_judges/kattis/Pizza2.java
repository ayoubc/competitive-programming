import java.util.Scanner;

public class Pizza2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r,c;
        r = sc.nextInt();
        c = sc.nextInt();

        double ans = 100 * square(((r - c) * 1.0)/r);
        System.out.println(ans);
    }

    public static double square(double x) {
        return x * x;
    }
}

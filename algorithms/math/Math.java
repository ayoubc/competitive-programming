
import java.util.ArrayList;
import java.util.List;

public class Math {

    /**
     * Get the prime factorization of a number n
     * @param n
     * @return List of primes
     */
    public static List<Long> getFactorisation(long n) {
        List<Long> res = new ArrayList<>();
        for (long i=2; i * i <= n; i++) {
            if (n % i == 0) res.add(i);
            while (n % i == 0) n /= i;
        }
        if (n > 1) res.add(n);
        return res;
    }

    /**
     * Euler's Totient function
     * @param n
     * @return number of number <= n that are co-prime with n
     */
    public static int phi(int n) {
        int res = n;
        for (int i=2; i*i <= n; i++) {
            if (n % i == 0) res -= res / i;
            while (n % i == 0) n /= i;
        }
        if (n > 1) res -= res / n;
        return res;
    }

    /**
     * Get the power of two that is greater of equal to k
     * @param k
     * @return a number that is a power of 2
     */
    public static int twoPower(int k){
        while((k&(k-1)) != 0){
            k++;
        }
        return k;
    }
}

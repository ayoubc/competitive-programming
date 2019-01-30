import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ChineseRemainder {
	
	// Implementation for the calculation of gcd using Euclides' algorithm
	// Also contains an efficient implementation of the extended Euclides' algorithm
	static class Euclides {
		
		// This simply computes gcd(a, b)
		static long gcd(long a, long b) {
			if (b == 0) {
				return a;
			}
			return gcd(b, a%b);
		}
		
		// Output for extended Euclides: these variables are filled by the methods below
		static long X, Y, gcd;
		
		// Solve aX+bY = gcd(a,b) for given a, b
		static void extendedEuclides(long a, long b) {
			long x = 0, y = 1, lastX = 1, lastY = 0, temp;
			while (b != 0) {
				long q = a / b;
				long r = a % b;
				a = b;
				b = r;
				temp = x;
				x = lastX - q * x;
				lastX = temp;
				temp = y;
				y = lastY - q * y;
				lastY = temp;
			}
			gcd = a;
			X = lastX;
			Y = lastY;
		}
		
		// Solves aX+bY = c ONLY IF gcd(a, b) = 1 for given a, b, c
		static void extendedEuclides(long a, long b, long c) {
			extendedEuclides(a, b);
			X *= c;
			Y *= c;
			long ag = a / gcd;
			long bg = b / gcd;
			if (X < 0) {
				long steps = (-X - 1) / bg + 1;
				X += bg * steps;
				Y -= ag * steps;
			}
			if (Y < 0) {
				long steps = (-Y - 1) / ag + 1;
				X -= bg * steps;
				Y += ag * steps;
			}
		}
		
	}
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(r.readLine());
        while (T-->0) {
            StringTokenizer s = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(s.nextToken());
            int m = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int n = Integer.parseInt(s.nextToken());
            long K = ((long) n)*m;
            Euclides.extendedEuclides(n, m, a-b);
            long ag = n/Euclides.gcd;
            long bg = m/Euclides.gcd;
            while (Euclides.Y >= 0) {
                long steps = Euclides.Y/ag+1;
                Euclides.X += bg*steps;
                Euclides.Y -= ag*steps;
            }
            long p = -Euclides.Y;
            long x = (a+p*m) % K;
            if (x < 0) {
                x += K;
            }
            w.write(x+" "+K+"\n");
        }
        w.flush();
    }
    
}
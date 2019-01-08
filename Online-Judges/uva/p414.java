import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int count[] = new int[n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < s.length(); j++)
					if (s.charAt(j) == 'X')
						count[i]++;
				max = Math.max(max, count[i]);
			}
			int ans = 0;
			for (int i = 0; i < n; i++)
				ans += max - count[i];
			out.println(ans);
		}
		out.close();
	}
 
}
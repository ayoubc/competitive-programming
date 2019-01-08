import java.util.*;
import java.math.*;
public class P {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,cases=0;
		String item,f,Zero = "0";
		BigInteger S,P,F,zero;
		while(sc.hasNext()){
			N = sc.nextInt();
			f = sc.nextLine();
			F = new BigInteger(f);
			zero = new BigInteger(Zero);
			if(N==0&&F.equals(zero)){
				break;
			}
			else{
				S = zero;
				cases =cases+1;
				for(int i=0;i<N;i++){
					item = sc.nextLine();
					BigInteger V = new BigInteger(item);
					S = S.add(V);
				}
				P = S.divide(F);
				System.out.println("Bill #"+cases+" costs "+S+": each friend should pay \n"+P);
			}
		}
		sc.close();
	}

}

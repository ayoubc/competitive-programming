#include<stdio.h>
#include<stdlib.h>
#include<math.h>
long long power(long long a,long long n){
	if(n==1) return a;
	long long d = power(a,n/2);
	if(n%2==0) return d*d;
	else return d*d*a;
}

int powerOfprimeInFactoriel(int p,int n){
	int ans = 0,divisors,x;
	for(x=1;;x++){
		divisors = n/power(p,x);
		if(divisors==0) break;
		ans += divisors;
	}
	return ans;
}
int main(){
	// freopen("i","r",stdin);
	// srand(time(NULL));
	int n,m;
	while(scanf("%d %d",&n,&m)==2){
		if(m==0) printf("%d does not divide %d!\n",m,n);
		else if(m<=n) printf("%d divides %d!\n",m,n);
		else{
			int ok = 1;
			int mm = m,j = sqrt(m),i;
			for(i=2;i<=j;i++){
				int k=0;
				while(m%i==0){
					k++;
					m /= i;
				}
				if(powerOfprimeInFactoriel(i,n)<k) {
					ok = 0;
					break;
				}
				j = sqrt(m);
			}
			if(m>1) {
				if(powerOfprimeInFactoriel(m,n)<1) ok = 0;
			}
			if(ok) printf("%d divides %d!\n",mm,n);
			else printf("%d does not divide %d!\n",mm,n);
		}
		
	}
}
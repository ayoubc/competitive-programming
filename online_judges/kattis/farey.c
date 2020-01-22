#include<stdio.h>
#include<math.h>

long long phi(long long n){
	long long sum = n;
	long long j = sqrt(n);
	int i;
	for(i=2;i<=j;i++){
		if(n%i==0){
			sum -= sum/i;
		}
		while(n%i==0) n/= i;
		j = sqrt(n);
	}
	if(n>1) sum -= sum /n;
	return sum;
}
long long fary[10001];
void compute(){
	fary[0] = 1;
	int i;
	for(i=1;i<=10000;i++){
		fary[i] = phi(i) + fary[i-1];
	}
}
int main(){
	// freopen("i","r",stdin);
	int P,K,N;
	compute();
	scanf("%d",&P);
	int i;
	for(i=0;i<P;i++){
		scanf("%d %d",&K,&N);
		long long ans = fary[N];
		printf("%d %lld\n",K,ans);
	}
	return 0;
}
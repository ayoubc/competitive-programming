#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
ll phi(ll n){
	ll sum = n;
	ll j = sqrt(n);
	for(int i=2;i<=j;i++){
		if(n%i==0){
			sum -= sum/i;
		}
		while(n%i==0) n/= i;
		j = sqrt(n);
	}
	if(n>1) sum -= sum /n;
	return sum;
}
ll fary[10001];
void compute(){
	fary[0] = 1;
	for(int i=1;i<=10000;i++){
		fary[i] = phi(i) + fary[i-1];
	}
}
int main(){
	// freopen("i","r",stdin);
	int P,K,N;
	compute();
	scanf("%d",&P);
	for(int i=0;i<P;i++){
		scanf("%d %d",&K,&N);
		ll ans = fary[N];
		// for(int j=1;j<=N;j++){
		// 	ans += phi(j);
		// }
		printf("%d %lld\n",K,ans);
	}
}
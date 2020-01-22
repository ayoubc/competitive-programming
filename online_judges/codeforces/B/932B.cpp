#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 1000005;
ll d[N][10];
ll f(int n){
	int p = 1,d;
	while(n){
		d = n%10;
		if(d){
			p *= d;
		}
		n /= 10;
	}
	return p;
}
ll g(int n){
	if(n<10){
		return n;
	}
	return g(f(n));
}
void compute(){
	for(int k=1;k<=9;k++){
		d[1][k] = (g(1)==k);
		for(int i=2;i<=N;i++){
			if(g(i)==k){
				d[i][k] = d[i-1][k]+1;
			}
			else{
				d[i][k] = d[i-1][k];
			}
		}
	}
}
int main(){
	// freopen("i","r",stdin);
	int q,l,r,k;
	ll ans;
	compute();
	scanf("%d",&q);
	while(q--){
		scanf("%d%d%d",&l,&r,&k);
		if(l==1)
			ans = d[r][k];
		else
			ans = d[r][k] - d[l-1][k];

		printf("%I64d\n",ans);
	}
}
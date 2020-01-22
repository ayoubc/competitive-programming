//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
const int N = 100005;
bool isprime[N];
void seive(){
	memset(isprime,true,sizeof(isprime));
	for(int i=2;i<N;i++){
		if(isprime[i]){
			for(int j=2*i;j<N;j+=i)
				isprime[j] = false;
		}
	}
}
ll F(int x){
	if(x==0) return 0;
	if(x==1) return 1;
	if(x==2) return 2;
	if(isprime[x]) return 0;
	int a=1,b=x;
	int s = sqrt(x);
	for(int i=2;i<=s;i++){
		if(x%i==0){
			if(a+b>i+x/i){
				a = i;
				b = x/i;
			}
		}
	}
	return F(a)+F(b);
}
int main(){
	int x;
	seive();
	scanf("%d",&x);
	ll ans = F(x);
	printf("%lld\n",ans);
	return 0;
}


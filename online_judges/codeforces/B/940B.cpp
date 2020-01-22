#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
//ll power(ll a,ll b){
//	if(b==0)
//		return 1;
//	ll d = power(a,b/2);
//	if(b%2==0)
//		return d*d;
//	else
//		return d*d*a;
//}
//ll MIN(ll a,ll b){
//	return (a<b)?a:b;
//}
int main(){
	// freopen("i","r",stdin);
	ll n,k,A,B,powerk = 0,x,a;
	ll ans = 0;
	scanf("%I64d %I64d %I64d %I64d",&n,&k,&A,&B);
	if(k==1 || n<k){
		ans = (n-1)*A;
	}
	else{
		while(n>1){
			if(n%k==0){
				a = n/k;
				if((k-1)*a*A<B){
					ans += (k-1)*a*A;
				}
				else{
					ans += B;
				}
				n /= k;
			}
			else{
				a = n%k;
				ans += a*A;
				n -= a;
				if(!n) ans -= A;
			}
		}
	}
	printf("%I64d\n",ans);
	
}

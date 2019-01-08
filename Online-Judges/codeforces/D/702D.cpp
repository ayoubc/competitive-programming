#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
const ll OO = 1000000000000000000;
ll MIN(ll a ,ll b){
	return (a<=b)?a:b;
}
int main(){
	// freopen("i","r",stdin);
	ll d,a,b,k,t,ans,n;
	scanf("%I64d %I64d %I64d %I64d %I64d",&d,&k,&a,&b,&t);
	n = d/k;
	ans = d*b;
	if(d<=k)
		ans = ans = d*a;
	else if(t+a*k>k*b)
		ans = k*a + (d - k)*b;
	else
		ans = n*k*a + (n-1)*t + MIN(t + (d%k)*a , (d%k)*b);
	printf("%I64d\n",ans);
}
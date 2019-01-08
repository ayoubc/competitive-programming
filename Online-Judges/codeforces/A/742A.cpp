#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int  power(int x,int p,int mod){
	if(p==0)
		return 1;
	int d = power(x,p/2,mod);
	if(p%2==0)
		return ((d%mod)*(d%mod))%mod;
	else
		return ((((d%mod)*(d%mod))%mod)*(x%mod))%mod;
}
int main(){
	int n;
	scanf("%d",&n);
	printf("%d\n",power(1378,n,10));
	return 0;
}


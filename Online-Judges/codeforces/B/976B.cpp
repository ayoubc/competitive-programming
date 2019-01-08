//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
	//freopen("i","r",stdin);
	ll n,m,k;
	scanf("%I64d %I64d %I64d",&n,&m,&k);
	ll d = (k-n)/(m-1);
	ll res = (k-n)%(m-1);
	ll ansx,ansy;
	if(k<=n-1){
		ansx = k+1;
		ansy = 1;
	}
	else {
		ansx = n - d;
		if(d%2==0){
			ansy = res+2;
		}
		else{
			ansy = m - res;
 		}
	}
	printf("%I64d %I64d\n",ansx,ansy);
	return 0;
}


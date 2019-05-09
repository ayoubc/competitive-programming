#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int maxpow(int k) {
	int p = 0;
	while((1<<p) < k) p++;
	return p;
}
int main(){
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%d",&t);
    while(t--){
    	int u,k;
    	scanf("%d%d",&u,&k);
    	int n = maxpow(k);
//    	cout<<n<<endl;
    	int s = 1<<(n-1);
    	ll U = (1LL<<(n-1)) * (1LL*u) + (1LL)*(k-s+1);
    	printf("%I64d\n",U);
	}
    return 0;
}

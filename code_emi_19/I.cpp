#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
ll Q(ll a, ll b, int x) {
	return b/x - (a-1)/x;
}
int main () {
//	freopen("i.txt","r",stdin);
	int t;
	scanf("%d",&t);
	while(t--){
		ll a,b;
		scanf("%I64d %I64d",&a,&b);
		printf("%I64d\n", Q(a, b, 400)+Q(a, b, 4) - Q(a, b, 100));
	}
	return 0;
}


#include <bits/stdc++.h>

using namespace std;
const int N = 100007;

int main () {
//	freopen("i.txt","r",stdin);
	int t;
	scanf("%d",&t);
	while(t--){
		int n,m;
		scanf("%d%d",&n,&m);
		int ans = N;
		for(int i=1;i<=1024;i++) {
			ans = min(ans, __builtin_popcount((i *m ) ^ n));
		}
		printf("%d\n",ans);
	}
	return 0;
}


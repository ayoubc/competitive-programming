//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
int c[100005];
typedef long long ll;
int main(){
//	freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	
	for(int i=0;i<n;i++) scanf("%d",&c[i]);
	sort(c,c+n);
	ll ans = 0;
	for(int i=n-1;i>=0;i-=3){
		ans += c[i] + c[i-1];
	}
	printf("%lld\n",ans);
	return 0;
}


#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
typedef long long ll;
ll a[N];
int main(){
//	freopen("i","r",stdin);
	int n,x,k;
//	while(scanf("%d%d%d",&n,&x,&k)==3){
		ll ans = 0;
		scanf("%d%d%d",&n,&x,&k);
		for(int i=0;i<n;i++){
			scanf("%I64d",&a[i]);
		}
		sort(a,a+n);
		ll val;
		for(int i=0;i<n;i++){
			val = (a[i]-1)/x + k;
			ans += lower_bound(a,a+n,(val+1)*x) - lower_bound(a,a+n,max(val*x,a[i]));
		}
		printf("%I64d\n",ans);
//	}
//	cout<<9/3<<" "<<(9+3-1)/3<<endl;
	return 0;
}


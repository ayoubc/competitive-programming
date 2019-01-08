#include<bits/stdc++.h>


using namespace std;
typedef long long ll;
const int N = 200005;
int n,q,l,r;
ll a[N],d[N],b[N];

int main(){
	// freopen("i","r",stdin);
	memset(d,0,sizeof(d));
	scanf("%d %d",&n,&q);
	for(int i=0;i<n;i++){
		scanf("%I64d",&a[i]);
	}
	for(int i=1;i<=q;i++){
		scanf("%d %d",&l,&r);
		l--,r--;
		d[l]++;
		d[r+1]--;
	}
	ll ans = 0;
	b[0] = d[0];
	for(int i=1;i<n;i++){
		b[i] = b[i-1]+d[i];
	}
	// for(int i=0;i<n;i++){
	// 	printf("%lld ",b[i]);
	// }
	sort(a,a+n);
	sort(b,b+n);
	for(int i=0;i<n;i++){
		ans += a[i]*b[i];
	}
	printf("%I64d\n",ans);
}
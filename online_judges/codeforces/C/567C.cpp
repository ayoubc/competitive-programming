#include<bits/stdc++.h>

using namespace std;
typedef long long ll; 
const int N = 200005;
ll a[N],AL[N],AR[N];
int main(){
	// freopen("i","r",stdin);
	int n,k;

	scanf("%d%d",&n,&k);
	map<ll,ll> occl,occr;
	for(int i=0;i<n;i++){
		scanf("%I64d",&a[i]);
		AL[i] = (a[i]%k==0?occl[a[i]/k]:0);
		occl[a[i]]++;
	}
	for(int i=n-1;i>=0;i--){
		AR[i] = occr[a[i]*k];
		occr[a[i]]++;
	}
	ll ans = 0;
	for(int i=0;i<n;i++){
		ans += AR[i]*AL[i];
	}
	printf("%I64d\n",ans);
}

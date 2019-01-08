#include<bits/stdc++.h>

using namespace std;
const int N = 100007;
typedef pair<int,int>pi;
typedef long long ll;
int a[N];
pi b[N];
int main(){
	// freopen("i","r",stdin);
	int n,cur;
	ll ans = 0;
	scanf("%d",&n);
	map<int,int> occ;
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
		occ[a[i]]++;
	}
	sort(a,a+n);
	for(int i=0;i<n;i++){
		for(int k=0;k<=31;k++){
			cur = (1<<k) - a[i];
			ans += upper_bound(a+i+1,a+n,cur) - lower_bound(a+i+1,a+n,cur);
		}
	}
	printf("%I64d\n",ans);
}

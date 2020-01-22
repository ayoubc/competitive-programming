#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int ,int > pi;
const int N = 100005;
int a[N];
pi b[N];
int main(){
	freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
		b[i].first = a[i];
		b[i].second = i;
	}
	sort(b,b+n);
	ll ans = 0;
	int j;
	for(int i=0;i<n-1;i++){
		j = abs(b[i+1].second - b[i].second);
		ans += min(j,n-j);
	}
	printf("%lld\n",ans);
}

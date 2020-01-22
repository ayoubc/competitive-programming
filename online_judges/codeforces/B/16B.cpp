#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
int main(){
//	freopen("input","r",stdin);
	int n,m,add,N;
	scanf("%d%d",&n,&m);
	vector<pi> v(m);
	for(int i=0;i<m;i++){
		scanf("%d%d",&v[i].second,&v[i].first);
	}
	sort(v.begin(),v.end());
	long long ans = 0;
	N = 0;
	for(int i=m-1;i>=0;i--){
		add = min(n-N,v[i].second);
		ans += add*v[i].first;
		N += add;
	}
	printf("%I64d\n",ans);
	return 0;
}


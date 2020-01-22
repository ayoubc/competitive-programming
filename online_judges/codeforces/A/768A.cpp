#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;
int main(){
//	freopen("i.in","r",stdin);
	int n,a;
	scanf("%d",&n);
	vector<pi> v(n);
	map<int,int> mp;
	for(int i=0;i<n;i++){
		scanf("%d",&a);
		mp[a]++;
		v[i].first = a;
		v[i].second = mp[a];
	}
	sort(v.begin(),v.end());
	int ans = 0;
	for(int i=1;i<n-1;i++){
		if(i>v[i].second-1 && mp[v[i].first] - v[i].second < n-i-1) ans++;
	}
	printf("%d\n",ans);
	return 0;
}


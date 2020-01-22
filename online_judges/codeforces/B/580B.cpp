#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll,ll> pi;
vector<pi> fr;

int main(){
//	freopen("i.in","r",stdin);
	int n;
	ll d,u,v,ans;
	scanf("%d %I64d",&n,&d);

	fr.clear();
	for(int i=0;i<n;i++){
		scanf("%I64d %I64d",&u,&v);

		fr.push_back(make_pair(u,v));
	}
	sort(fr.begin(),fr.end());
	int j = 0;
	ll temp = 0;
	ans = 0;
	for(int i=0;i<n;i++){
		if(fr[i].first - fr[j].first < d){
			temp += fr[i].second;
			ans = max(ans,temp);
		}
		else{
			temp -= fr[j++].second;
			i--;
		}
	} 
	
	printf("%I64d\n",ans);

	return 0;
}


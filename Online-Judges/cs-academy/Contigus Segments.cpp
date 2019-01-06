#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
long  long Min(long long a,long long b){
	return (a<=b) ? a:b;
}
vector<pi> __init(vector<pi> v){
	vector<pi> V(v.size());
	for(int i=0;i<v.size();i++){
		V[i].first = v[i].first;
		V[i].second = v[i].second;
		
	}
	return V;
}

int main() {
	// freopen("i.in","r",stdin);
    int n;
    scanf("%d",&n);
    vector<pi> seg(n);
    for(int i=0;i<n;i++) scanf("%d %d",&seg[i].first,&seg[i].second);
    sort(seg.begin(),seg.end());
    long long  ans = (long long)1e13,cnt,dif;
	for(int i=0;i<n;i++){
		cnt = 0;
		vector<pi> newseg = __init(seg);
		for(int j=i;j>0;j--){
			dif = newseg[j].first - newseg[j-1].second;
			newseg[j-1].first += dif;
			
			cnt += dif;
		}
		for(int j=i;j<n-1;j++){
			dif = newseg[j+1].first - newseg[j].second;
			newseg[j+1].second -= dif;
			// sge[j+1].first -= dif;
			cnt += dif;
			
		}
		ans = Min(ans,cnt);
	}
	printf("%lld",ans);
    return 0;
}
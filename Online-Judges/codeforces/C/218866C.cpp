#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll,int> pi;
const ll OO = 1000000000000000000;
int main(){
//	freopen("i","r",stdin);
	int n,I;
	scanf("%d",&n);
	vector<ll> d(n,0);
	vector<ll> x(n);
	vector<pi> X(n);
	ll sum = 0,ans,cur;
	
	for(int i=0;i<n;i++){
		scanf("%I64d",&x[i]);
		X[i].first = x[i];
		X[i].second = i;
	}
	sort(X.begin(),X.end());
	for(int i=0;i<n;i++){
		if(i==0)
			d[i] = X[i].first;
		else
			d[i] = d[i-1] + X[i].first;
	}
	ans = OO;
//	for(int i=0;i<n;i++)
//		printf("%d\n",d[i]);
	for(int i=0;i<n;i++){
		if(i==0)
			cur = d[n-1] - n*(X[0].first);
		else
			cur = (2*i-n+1)*(X[i].first) + d[n-1] - d[i] - d[i-1];
//		printf("%d\n",cur);
		if(ans > cur){
			I = X[i].second;
//			printf("%d\n",i);
//			printf("Hello\n");
			ans = cur;
		}
	}
	printf("%I64d\n",x[I]);
	return 0;
}


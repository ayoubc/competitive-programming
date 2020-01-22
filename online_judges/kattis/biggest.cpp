#include <bits/stdc++.h>
using namespace std;
double const pi = acos(-1);
typedef long long ll;
const int N_SECOND = 1296000;
ll Max(ll a, ll b){
	return (a<b ? b:a);
}
ll Min(ll a, ll b){
	return (a<b ? a:b);
}
bool a[N_SECOND];
int main(){
//	freopen("i","r",stdin);
	int n,m,angle,minute,second,r,angleTotal;
	double ans;
	scanf("%d",&m);
	while(m--){
		scanf("%d %d %d %d %d",&r,&n,&angle,&minute,&second);
		fill(a,a+N_SECOND,false);
		angleTotal = angle*3600 + minute*60 + second;
		int cur=0;
		for(int i=0;i<n;i++){
			if(a[cur]) break;
			a[cur] = true;
			cur = (cur+angleTotal)%N_SECOND;
		}
		int lastcut = 0 , consecutiveSecond = 0, maxConsecutiveSeconds = 0;
		for(int i=0;i<N_SECOND;i++){
			consecutiveSecond++;
			if(a[i]){
				lastcut = i;
				maxConsecutiveSeconds = max(maxConsecutiveSeconds, consecutiveSecond);
				consecutiveSecond = 0;
			}
		}
		maxConsecutiveSeconds = max(maxConsecutiveSeconds , N_SECOND - lastcut);
		ans = 1.0*r*r*pi*maxConsecutiveSeconds/N_SECOND;
		printf("%.6lf\n",ans);
	}
	return 0;
}


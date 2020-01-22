#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
int c[5005],cost[5005];
pi capital[5005];
int main(){
	// freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&c[i]);
		if(i==0) cost[i] = 0;
		else cost[i] = cost[i-1] + c[i-1];
	}
	int cur;
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(i==j) continue;
			if(i<j) cur = min(abs(cost[j]-cost[i]) , abs(cost[i]+c[n-1]+cost[n-1]-cost[j]));
			else cur = min(abs(cost[j]-cost[i]) , abs(cost[j]+c[n-1]+cost[n-1]-cost[i]));
			capital[i].first = max(capital[i].first,cur);
			capital[i].second = i;
		}
	}
	sort(capital,capital+n);
	printf("%d\n",capital[0].second+1);
	// for(int i=0;i<n;i++)printf("%d ",capital[i]);
}
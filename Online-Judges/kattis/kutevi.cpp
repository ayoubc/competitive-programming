#include <bits/stdc++.h>
using namespace std;
//bool vis[365]
int main(){
//	freopen("i","r",stdin);
	int n,k;
	scanf("%d %d",&n,&k);
	vector<int> hecan(n),selec(k),poss;
	for(int i=0;i<n;i++){
		scanf("%d",&hecan[i]);
	}
	for(int i=0;i<k;i++){
		scanf("%d",&selec[i]);
	}
	vector<bool> vis(361,false);
	queue<int> q;
	q.push(hecan[0]);
	while(!q.empty()){
		int e = q.front();q.pop();
		if(vis[e])
			continue;
		vis[e] = true;
		for(int i=0;i<n;i++){
			q.push(abs(hecan[i] - e));
			q.push((hecan[i] + e)%360);
		}
	}
	for(int i=0;i<k;i++){
		if(vis[selec[i]])
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}


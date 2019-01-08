#include <bits/stdc++.h>

using namespace std;
#ifdef home
	eprintf("Time: %d ms\n", (int)(clock() * 1000. / CLOCKS_PER_SEC));
#endif
    
const int X = 30005;
int a[X];
vector<bool> vis; 
int n,t;
bool dfs(int s){
	if(s==t) return true;
	if(vis[s]) return false;
	vis[s] = true;
	return dfs(s+a[s]);
}
int main(){
	freopen("i.in","r",stdin);
	scanf("%d %d",&n,&t);
	vis.resize(n+1,false);
	for(int i=1;i<n;i++) scanf("%d",a+i);
	if(dfs(1)) printf("YES\n");
	else 
		printf("NO\n");
		
	//printf("Time: %d ms\n", (int)(clock() * 1000. / CLOCKS_PER_SEC));
	return 0;
}


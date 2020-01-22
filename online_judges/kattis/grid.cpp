#include<bits/stdc++.h>
using namespace std;

char s[505][505];
int dist[505][505];
bool vis[505][505];
typedef pair<int,int> pi;
typedef pair<int,pi> pii;
const int OO = 1000000;
int n,m;
bool check(int i,int j){
	return (i>=0 && i<n) && (j>=0 && j<m);
}
int main(){
	// freopen("i","r",stdin);
	
	scanf("%d%d",&n,&m);
	for(int i=0;i<n;i++)
		scanf("%s",&s[i]);
	// for(int i=0;i<n;i++) printf("%s\n",s[i]);
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
			vis[i][j] = false;
			dist[i][j] = OO;
		}
	}
	multiset<pii> q;
	dist[0][0] = 0;
	q.insert(make_pair(0,make_pair(0,0)));
	while(!q.empty()){

		pii p = *(q.begin());
		q.erase(q.begin());
		int r = p.second.first, c = p.second.second , pas = s[r][c] - '0';
		if(vis[r][c]) continue;
		// cout<<r<<" "<<c<<endl;
		vis[r][c] = true;
		if(check(r,c+pas)){
			if(dist[r][c] + 1 < dist[r][c+pas]){
				dist[r][c+pas] = dist[r][c] + 1;
				q.insert(make_pair(dist[r][c+pas],make_pair(r,c+pas)));
			}
		}
		if(check(r,c-pas)){
			if(dist[r][c] + 1 < dist[r][c-pas]){
				dist[r][c-pas] = dist[r][c] + 1; 
				q.insert(make_pair(dist[r][c-pas],make_pair(r,c-pas)));	
			}
		}
		if(check(r+pas,c)){
			if(dist[r][c] + 1 < dist[r+pas][c]){
				dist[r+pas][c]  = dist[r][c] + 1;
				q.insert(make_pair(dist[r+pas][c],make_pair(r+pas,c)));	
			}
		}
		if(check(r-pas,c)){
			if(dist[r-pas][c] > dist[r][c] + 1){
				dist[r-pas][c] = dist[r][c] + 1;

				q.insert(make_pair(dist[r-pas][c],make_pair(r-pas,c)));
			}
		}
		
	}
	if(dist[n-1][m-1]==OO) printf("-1\n");
	else printf("%d\n",dist[n-1][m-1]);
	return 0;
}
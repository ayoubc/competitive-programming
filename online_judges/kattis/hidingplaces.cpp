#include<bits/stdc++.h>

using namespace std; 
bool ok(int i,int j){
	return (i>=0 && i<8 && j>=0 && j<8);
}
const int OO = 100000;
typedef pair<int,int> pi;
typedef pair<int,pi> pii;
bool cmp(pi p1,pi p2){
	if(p1.first==p2.first) return p1.second<p2.second;
	return p1.first > p2.first;
}
bool vis[10][10];
int dis[10][10];
int dx[] = {-1,1,-2,-2,-1,1,2,2}  , dy[] = {-2,-2,-1,1,2,2,1,-1};
int main(){
	// freopen("i","r",stdin);
	int n,ans;
	char s[3];
	scanf("%d",&n);
	while(n--){
		scanf("%s",&s);
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				vis[i][j] = false;
				dis[i][j] = OO;
			}
		}
		queue<pii> q;
		vector<pi> v;
		q.push(make_pair(0,make_pair(s[1]-'1',s[0]-'a')));
		// cout<<7-(s[1] - '1')<<" "<<s[0] - 'a'<<endl;
		while(!q.empty()){
			pii p = q.front();q.pop();
			int i = p.second.first , j = p.second.second,w = p.first;
			if(vis[i][j]){
				continue;
			}
			vis[i][j] = true;
			for(int k=0;k<8;k++){
				if(ok(i+dx[k],j+dy[k])){
					if(dis[i+dx[k]][j+dy[k]] > w+1){
						dis[i+dx[k]][j+dy[k]] = w+1;
						q.push(make_pair(w+1,make_pair(i+dx[k],j+dy[k])));
					}
				}
			}
		}
		ans = 0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(dis[i][j]!=OO) ans = max(ans,dis[i][j]);
			}
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(dis[i][j]==ans){
					v.push_back(make_pair(i,j));
				}
			}
		}
		printf("%d ", ans);
		sort(v.begin(),v.end(),cmp);
		for(int i=0;i<v.size();i++)
		 	printf("%c%c ",'a'+v[i].second,'1'+v[i].first);
		printf("\n");
	}
}
#include <bits/stdc++.h>

using namespace std;
const int OO = (int)1e09;
int main(){
//	ifstream cin("i.in");
	ios::sync_with_stdio(false);
	int n,m,u,v,D,Q;
	cin >> n >> m;
	string name1,name2;
	map<string, int> mp;
	int dist[n][n];
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(i==j) dist[i][j] = 0;
			else dist[i][j] = OO ;
		}
	}
	for(int i=0;i<n;i++){
		cin >> name1;
		mp[name1] = i;
	}
	for(int i=0;i<m;i++){
		cin >> name1 >> name2 >> D;
	
		u = mp[name1] , v = mp[name2];
		dist[u][v] = dist[v][u] = D;

	}
	for(int k=0;k<n;k++){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j]);
			}
		}
	}
	cin >> Q;
	for(int i=0;i<Q;i++){
		cin >> name1 >> name2;
		u = mp[name1] , v = mp[name2];
		cout << dist[u][v] <<endl;
	}
	
	return 0;
}


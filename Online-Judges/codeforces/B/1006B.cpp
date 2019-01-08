#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;


int main(){
	//freopen("i.txt","r",stdin);
	int n,k,a;
	scanf("%d%d",&n,&k);
	vector<pi> V;
	for(int i=0;i<n;i++){
		scanf("%d",&a);
		V.push_back(make_pair(a,i));
	}
	sort(V.rbegin(),V.rend());
	vector<int> v;
	int sum = 0;
	for(int i=0;i<k;i++){
		sum += V[i].first;
		v.push_back(V[i].second);
	}

	sort(v.begin(),v.end());
	//for(int i=0;i<v.size();i++) printf("%d ",v[i]);
	vector<bool> vis(n,false);
	for(int i=0;i<v.size();i++){
		vis[v[i]] = true;
	}
	printf("%d\n",sum);
	for(int i=0;i<v.size();i++){
		int j = v[i];
		int l = j-1,cnt,r=j+1;
	
		while(l>=0 && !vis[l]){
			vis[l] = true;
			l--;
		}
		while(r<n && !vis[r]){
			vis[r] = true;
			r++;
		}
		printf("%d ",r-l-1);
	}
	return 0;
}


#include<bits/stdc++.h>
using namespace std;
vector<int> f(int n,int p){
	vector<int> v;
	for(int i=2;i*i<=n;i++){
		if(n%i==0){
			if(i<=p)v.push_back(i);
			if(n/i!=i && n/i<=p) v.push_back(n/i);
		}
	}
	return v;
}
int main(){
	// freopen("i","r",stdin);
	int p,y,ans=-1;
	scanf("%d%d",&p,&y);
	bool found = false;
	for(int i=y;i>p;i--){
		vector<int> v = f(i,p);
		if(v.size()==0){
			found = true;
			ans = i;
			break;
		}
	}
	cout<<ans<<endl;
}
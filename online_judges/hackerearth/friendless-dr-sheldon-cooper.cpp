#include <bits/stdc++.h>

using namespace std;
int a,b,n,m;
int main(){
	ifstream cin("i.in","r",stdin);
	ios::sync_with_stdio(false);
	int t;
	cin>> t;
	while(t--){
		cin>> a >> b;
		for(int i=0;i<b;i++){
			cin >> n >> m;
		}
		cout<<a - 1<<endl;
	}
	
	return 0;
}


//slowly but surly!
#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int n;
	string s;
	cin >> n;
	cin >> s;
	map<string,int> M;
	for(int i=0;i<n-1;i++){
		string S = s.substr(i,2);
		M[S]++;
	}
	int ans = INT_MIN;
	string res;
	for(map<string,int>::iterator it=M.begin();it!=M.end();it++){
		if(ans<it->second){
			ans = it->second;
			res = it->first;
		}
	}
	cout<<res<<endl;
	return 0;
}


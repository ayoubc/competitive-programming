#include <bits/stdc++.h>

using namespace std;
 

int main(){
	ios_base::sync_with_stdio(false);
	//ifstream cin("i.in");
	int t,ans;
	string s;

	cin>>t;
	while(t--){
		cin>>s;
		ans = 0;

		for(int i=0;i<s.size();i++){
			stringstream ss;
			string str = s.substr(0,i+1);
			int n;
			ss << str , ss >> n;
			ans = max(ans,__builtin_popcount(n));
		}
		printf("%d\n",ans);
	}
	return 0;
}


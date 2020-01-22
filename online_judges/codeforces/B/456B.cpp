#include <bits/stdc++.h>

using namespace std;



int main(){
	ios_base::sync_with_stdio(false);
	//ifstream cin("i.txt");
	
	string s;
	cin>>s;
	int ans,n = s.size();
	if(n==1) ans = s[0]-'0';
	else ans = 10*s[n-2] + s[n-1];
	if(ans%4==0) cout<<"4\n";
	else cout<<"0\n";
	return 0;
}


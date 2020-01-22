#include <bits/stdc++.h>

using namespace std;

int main(){
	ios_base::sync_with_stdio(0);
	string s;
	int n;
	cin>>s;
	n = s.size();
	for(int i=0;i<s.size();i++){
		if((s[i]=='P' && i%3==0) || (s[i]=='E'&& i%3==1) || (s[i]=='R' && i%3==2)) n--;
	}
	cout<<n<<endl;
	return 0;
}


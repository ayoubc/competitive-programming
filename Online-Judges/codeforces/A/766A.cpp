#include <bits/stdc++.h>

using namespace std;

int main(){
	string a,b;
	cin >>a >>b;
	int ans;
	if(a==b) 
		ans = -1;
	else 
	 	ans = max(a.size(),b.size());
	cout<<ans<<endl;
	return 0;
}


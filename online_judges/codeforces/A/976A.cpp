//slowly but surly!
#include <bits/stdc++.h>
using namespace std;

int main(){
	string s;
	int a[2] = {0,0};
	int n;
	cin >> n;
	cin >> s;
	for(int i=0;i<n;i++){
		if(s[i]=='1') a[1]++;
		else a[0]++;
	}
	if(a[1]==1 || s=="0"){
		cout<<s<<endl;
		return 0;
	}
	string ans = "";
	for(int i=1;i<=a[0];i++){
		ans += "0";
	}
	ans = "1"+ ans;
	cout<<ans<<endl;
	return 0;
}


#include <bits/stdc++.h>

using namespace std;
bool div64(string s){
	int i=0,cnt=0;
	while(s[i]=='0'){
		i++;
	}
	for(int j=i;j<s.size();j++){
		if(s[j]=='0') cnt++;
	}
	return cnt>=6;
}
int main(){
//	freopen("i.in","r",stdin);
	string s;
	cin >> s;
	cout<<(div64(s) ? "yes":"no")<<endl;
	return 0;
}


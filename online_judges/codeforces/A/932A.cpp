#include<bits/stdc++.h>

using namespace std;
bool ispal(string s){
	int n = s.size();
	for(int i=0;i<n/2;i++){
		if(s[i]!=s[n-1-i]){
			return false;
		}
	}
	return true;
}
string reverse(string s){
	string S = "";
	for(int i=s.size()-1;i>=0;i--){
		S = S + s[i];
	}
	return S;
}
int main(){
	// freopen("i","r",stdin);
	string s,B;
	cin >> s;
	if(ispal(s)){
		B = s;
	}
	else{
		B = s+reverse(s);
	}
	cout<<B<<endl;
}
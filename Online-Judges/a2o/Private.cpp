#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	int n,f,sn,se;
	//ifstream cin("I");
	string s;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>s;
		f = s.find(".");
		sn = 0;
		se = 0;
		for(int j=0;j<f;j++){
			if(s[j]<97) sn +=  s[j]-'A'+1;
			else{
				sn += s[j]-'a'+1;
			}
		}
		for(int j=f+1;j<s.size();j++){
			if(s[j]<97) se +=  s[j]-'A'+1;
			else{
				se += s[j]-'a'+1;
			}
		}
		if(sn!=se) cout<<s<<endl;
	}
	return 0;
}


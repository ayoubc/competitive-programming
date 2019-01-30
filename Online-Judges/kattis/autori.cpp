#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	//ifstream cin("i");
	string s,S="";
	cin>>s;
	S += s[0];
	int p;
	p = s.find("-");
	while(p!=string::npos){
		S += s[p+1];
		p = s.find("-",p+1);
	}
	cout<<S<<endl;
	return 0;
}


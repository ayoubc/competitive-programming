#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	int n;
	string s;
	cin>>s;
	n = s.size();
	bool flag = true;
	for(int i=0;i<n/2;i++){
		int d = abs((int)s[i]-(int)s[n-i-1]);
		if(d!=0 && d!=32){
			flag = false;
			break;
		}
	}
	if(flag) cout<<"Palindrome\n";
	else cout<<"Not Palindrome\n";
	return 0;
}


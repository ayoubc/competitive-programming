#include<iostream>
#include <bits/stdc++.h>
#include <string>
#include <sstream>
using namespace std;
bool ispalindrome(long x);
int main(){
	long long p = INT_MIN,prod;
	for(int j=999;j>=100;j--){
		for(int k=999;k>=100;k--){
			prod = j*k;
			if(ispalindrome(prod)){
				p = max(p,prod);
			}
		}
	}
	printf("%ld\n",p);
	return 0;
}
bool ispalindrome(long x){
	stringstream ss;
	string s;
	ss << x , ss >> s;
	int n = s.size();
	for(int i=0;i<n/2;i++){
		if(s[i]!=s[n-1-i]){
			return false;
		}
	}
	return true;
}

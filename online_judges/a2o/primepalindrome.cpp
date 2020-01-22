#include <bits/stdc++.h>
using namespace std;
bool ispalindrome(long long p){
	stringstream ss;
	string s;
	ss << p, ss >> s;
	int n = s.size();
	for(int i=0;i<n/2;i++){
		if(s[i]!=s[n-i-1])
			return false;
	}
	return true;
}
bool prime(long long p){

	if(p==2)
		return true;
	if(p%2==0 || p==1)
		return false;
	for(int i=3;i*i<=p;i+=2){
		if(p%i==0)
			return false;
	
	}
	return true;
}
int main(){
	long long p;
	scanf("%lld",&p);
	bool ok = false;
	while(!ok){
		if(ispalindrome(p)){
			if(prime(p)){
				ok = true;
			}
		}
		p++;
	}
	printf("%lld\n",p-1);
	return 0;
}


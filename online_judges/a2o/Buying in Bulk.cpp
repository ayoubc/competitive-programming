#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	int t,n,p;
	//ifstream cin("I");
	cin>>t;
	for(int tt=0;tt<t;tt++){
		cin>>n>>p;
		cout<<n<<" "<<p<<endl;
		cout<<n*p-(n-1)*2<<endl;
	}
	return 0;
}


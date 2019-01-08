#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	int t,n,sum,x;
	//ifstream cin("I");
	cin>>t;
	for(int tt=1;tt<=t;tt++){
		cin>>n;
		sum = 0;
		for(int i=0;i<n;i++){
			cin>>x;
			sum += x;
		}
		cout<<"Case "<<tt<<": "<<sum<<endl;
	}
	return 0;
}


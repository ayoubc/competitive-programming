#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	int n,k,x,s;
	//ifstream cin("I");
	string name,tran;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>name;
		cin>>s>>k;
		for(int j=0;j<k;j++){
			cin>>tran>>x;
			if(tran=="sell"){
				s += x;
			}
			else{
				s -= x;
			}
		}
		cout<<name<<" "<<s<<endl;
	}
	return 0;
}


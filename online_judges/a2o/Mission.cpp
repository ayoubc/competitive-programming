#include<iostream>
#include <bits/stdc++.h>
#include <vector>
#include <map>
using namespace std;

int main(){
	int t,n,m,k;
	//ifstream cin("I");
	string team,c;
	cin>>t;
	for(int i=1;i<=t;i++){
		cin>>n>>m>>k;
		map<string,int> ma;
		vector<string> v;
		for(int j=0;j<n;j++){
			cin>>team>>c;
			ma[c]++;
			if(ma[c]<=m && v.size()<k){
				v.push_back(team);
			}
		}
		cout<<"Case "<<i<<": \n";
		for(int j=0;j<v.size();j++){
			cout<<v[j]<<endl;
		}
	}
	return 0;
}


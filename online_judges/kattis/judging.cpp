#include<iostream>
#include <bits/stdc++.h>
#include <map>

#include <set>
#include <iterator>
using namespace std;

int main(){
	//ifstream cin("i");
	int n,sum=0;
	cin>>n;
	string s;
	map<string,int> mK;
	map<string,int> mD;
	set<string> st;
	for(int i=0;i<n;i++){
		cin>>s;
		mK[s]++;
		st.insert(s);
	}
	for(int i=0;i<n;i++){
		cin>>s;
		mD[s]++;
		st.insert(s);
	}
	for(set<string>::iterator it=st.begin();it!=st.end();it++){
		string S = *it;
		sum += min(mK[S],mD[S]);
	}
	cout<<sum<<endl;
	return 0;
}


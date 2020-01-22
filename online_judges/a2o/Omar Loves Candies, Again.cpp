#include<iostream>
#include <bits/stdc++.h>
#include <vector>
#include <map>
using namespace std;
typedef pair<int,char> p;
bool cmp(p p1,p p2){
	if(p1.first==p2.first) return p1.second>p2.second;
	return p1.first<p2.first;
}
int main(){
	int t;
	//ifstream cin("I");
	string s;
	cin>>t;
	for(int tt=0;tt<t;tt++){
		cin>>s;
		map<char,int> m;
		vector<p> v;
		for(int i=0;i<s.size();i++){
			m[s[i]]++;
		}
		for(int i=0;i<s.size();i++){
			v.push_back(make_pair(m[s[i]],s[i]));
		}
		sort(v.rbegin(),v.rend(),cmp);
		cout<<v[0].first<<" "<<v[0].second<<endl;
	}
	return 0;
}


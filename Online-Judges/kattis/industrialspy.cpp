#include<iostream>
#include <bits/stdc++.h>
#include <string>
#include <algorithm>
#include <fstream>
#include <vector>
#define Max 10000000
using namespace std;
int main(){
	//ifstream cin("A.in");
	//ofstream cout("1.txt");
	vector <bool> Prime(Max,true);
	for(int p=2;p*p<=Max;p++){
		if(Prime[p]){
			for(int i=2*p;i<=Max;i+=p){
				Prime[i] = false;
			}
		}
	}
	Prime[0] = false;
	Prime[1] = false;
	int t;
	cin>>t;
	for(int d=1;d<=t;d++){
		string s,sub;
		cin>>s;
		sort(s.begin(),s.end());//to use next_permutation you must sort the string
		set<int> primes;
		int l = s.size();
		do{
			for(int i=1;i<=l;i++){
				sub = s.substr(0,i);
				stringstream ss;
				long n;
				ss << sub, ss >> n;
				if(Prime[n]){
					primes.insert(n);
				}
			}
		}while(next_permutation(s.begin(),s.end()));
		//for(set<int>::iterator it=primes.begin();it!=primes.end();it++) cout<<*it<<endl;
		cout<<primes.size()<<endl;
	}
	return 0;
}

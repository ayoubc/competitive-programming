#include<iostream>
#include <bits/stdc++.h>
#include <string>
#include <algorithm>
#include <fstream>
#include <vector>
#define Max 10000000
using namespace std;
int main(){
	//the use of concept subsets of the set of digits
	//gives wrong answer
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
		string s,sub;//=1276543
		cin>>s;
		int l = s.size(),comp=0;
		int x=0;
		for(int i=0;i<l;i++){
			x |= (1<<(s[i]-'0'));
		}
		int b= 0;
		while(b=(b-x)&x){
			sub = "";
			for(int j=0;j<32;j++){
				if(b&(1<<j)){
					sub += j+'0';
				}
			}
			do{
				stringstream ss;
				long n;
				ss << sub, ss >> n;
				if(Prime[n]){
					comp++;
				}
			}while(next_permutation(sub.begin(),sub.end()));
		}
		/*if(sub.size()<l){
			do{
				stringstream ss;
				long n;
				ss << s, ss >> n;
				if(Prime[n]){
					comp++;
				}
			}while(next_permutation(s.begin(),s.end()));
		}*/
		cout<<comp<<endl;
	}
	return 0;
}

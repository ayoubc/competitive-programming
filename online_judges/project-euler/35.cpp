#include<iostream>
#include <bits/stdc++.h>
#include <algorithm>
#include <string>
using namespace std;
bool isPrime(long p);
int main(){
	ofstream cout("out.txt");
	long comp=13;
	bool flag;
	for(int n=101;n<=1000000;n+=2){
		flag = true;
		stringstream ss;
		string s;
		ss << n; ss >> s;
		for(int j=1;j<=s.size();j++){
			rotate(s.begin(),s.begin()+1,s.end());
			//cout<<s<<endl;
			stringstream SS;
			long p;
			SS << s, SS >> p;
			if(!isPrime(p)){
				flag = false;
				break;
			}
		}
		if(flag){
			cout<<n<<endl;
			comp++;
		}
	}
	cout<<"Here it is the result : the number of cerculare numbers below 10^6"<<endl;
	cout<<comp<<endl;
	return 0;
}
bool isPrime(long p){
	if(p==2){
		return true;
	}
	else if(p==1||p%2==0){
		return false;
	}
	else{
		for(int i=3;i*i<=p;i+=2){
			if(p%i==0){
				return false;
			}
		}
		return true;
	}
}

#include<iostream>
#include<sstream>
#include<fstream>
#include<vector>
#include<algorithm>
#include<string>
#include<cmath>
using namespace std;
int is_tidy(string x);
int main(){
	ifstream in("B-large.in");
	ofstream out("B-large.out");
	int T,p,l,L;
	long long N,x;
	in >> T;
	for(int i=1;i<=T;i++){
		in >> N;
		stringstream SS,sS,Ss,ss;
		string str,sub,s="";
		SS << N, SS >> str;
		l = str.size();
		p = is_tidy(str);
		if(p!=-1){
			while(p>0 && str[p]==str[p-1]){
				p--;
			}
			if(str[p+1]=='0') sub = str.substr(0,p+2),L = l-p-2;
			else sub = str.substr(0,p+1), L = l-p-1;
			sS << sub, sS >> x;
			x--;
			Ss << x, Ss >> s;
			for(int k=1;k<=L;k++){
				s += "9";
			}
			ss << s, ss >> x;
			out<<"Case #"<<i<<": "<<x<<endl;	
		}
		else out<<"Case #"<<i<<": "<<str<<endl;
	}
	return 0;
}
int is_tidy(string x){
	for(int j=0;j<x.size()-1;j++){
		if(x[j]>x[j+1]){
			return j;
		}
	}
	return -1;
}

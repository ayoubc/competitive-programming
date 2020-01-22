#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
using namespace std;
int binry_decimal(string byn);
int main(){
	int T,B;
	string S,s,str;
	ifstream in("code jam for girls.in");
	ofstream out("code jam for girls.out");
	in>>T;
	for(int i=1;i<=T;i++){
		in>>B;
		in>>S;
		s = "";
		for(int j=1;j<=B;j++){
			str = S.substr(0,8);
			S.replace(0,8,"");
			for(int k=0;k<8;k++){
				if(str[k]=='O'){
					str.replace(k,1,"0");
				}
				if(str[k]=='I'){
					str.replace(k,1,"1");
				}
			}
			s = s+(char)binry_decimal(str);
		}
		out<<"Case #"<<i<<": "<<s<<endl;
	}
	in.close();
	out.close();
	return 0;
}
int binry_decimal(string byn){
	int n=byn.size(),sum=0;
	for(int t=0;t<n;t++){
		if(byn[t]=='1'){
			sum = sum+pow(2,n-1-t);
		}
	}
	return sum;
}


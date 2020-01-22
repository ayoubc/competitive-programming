#include<iostream>
#include<sstream>
#include<fstream>
#include<string>
#include<cmath>
#include <stdio.h>
using namespace std;
double dp[1000000];
double L(long k){
	if(k==0) {
		return 0;
	}
	if(dp[k]) {
		return dp[k];
	}
	else{
		dp[k] = L(k-1)+log10(k);
		return dp[k];	
	}
	
}
long fact(long p){
	if(p==0){
		return 1;
	}
	else{
		return fact(p-1)*p;	
	}
}

int main(){
	//ifstream in("sample.in");
	string factorial;
	long n,lengh,k;
		cin >> factorial;
		if(factorial.size()<=7){
			stringstream ss ;
			long  N,k=1;
			ss << factorial, ss >> N;
			while(fact(k)!=N){
				k++;
			}
			cout<<k<<endl;
		}
		else{
			n = factorial.size();
			k = 10;
			lengh = (long int)L(k)+1;
			while(lengh!=n){
				k++;
				lengh = (long int)L(k)+1;
			}
			cout<<k<<endl;
		}
	
	return 0;
}


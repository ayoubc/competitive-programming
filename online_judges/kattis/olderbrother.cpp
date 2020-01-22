#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;
bool isprime_power(long long q);
bool isprime(long long p);
int main(){
	//ifstream file("sample1.in");
	long long q;
	//file>>q;
	cin>>q;
	if(q==1){
		cout<<"no"<<endl;
	}
	else if(isprime_power(q)){
		cout<<"yes"<<endl;
	}
	else{
		cout<<"no"<<endl;
	}
	return 0;
}
bool isprime_power(long long q){
	long long n = sqrt(q),dev_prec;
    if(isprime(q)){
    	return true;
	}
    else if(q%2==0){
    	while(q%2==0){
    		q=q/2;
		}
		if(q==1){
			return true;
		}
		else{
			return false;
		}
	}
	else{
		for(int j=3;j<=n;j=j+2){
			if(isprime(j)){
				if(q%j==0){
					dev_prec = j;
					break;
				}
			}
		}
		while(q%dev_prec==0){
			q = q/dev_prec;
		}	
		if(q==1){
			return true;
		}
		else{
			return false;
		}
	}
}
bool isprime(long long p){
	long long s = sqrt(p);
	if(p==2){
		return true;
	}
	else if(p%2==0){
		return false;
	}
	else{
		for(int i=3;i<=s;i=i+2){
			if(p%i==0){
				return false;
			}
		}
		return true;
	}
}

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int is_prime(long long p);
int main(){
	vector <long long>primes;
	long long q = sqrt(600851475143);
	for(int i=3;i<=q;i=i+2){
		if(600851475143%i==0){
			if(is_prime(i)){
				primes.push_back(i);
			}
		}
	}
	int n = primes.size();
	cout<<primes[n-1]<<endl;
	return 0;
}
int is_prime(long long p){
	long long q = sqrt(p);
	if(p==2){
		return 1;
	}
	else{
		for(int i=3;i<=q;i=i+2){
			if(p%i==0){
				return 0;
			}
		}
		return 1;
	}
}


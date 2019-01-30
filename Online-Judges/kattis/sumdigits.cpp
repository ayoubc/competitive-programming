#include <iostream>
#include <stdio.h>
#include <cmath>
using namespace std;
long long sum(long long N);
int main(){
	int t;
	long long a,b,sumdigit;
	scanf("%d",&t);
	for(int i=0;i<t;i++){
		scanf("%lld %lld",&a,&b);
		sumdigit = sum(b)-sum(a-1);
		cout<<sumdigit<<endl;
	}
	return 0;
}
long long sum(long long N){
	if(N<10){
		return N*(N+1)/2;
	}
	// computing sum of digits from 1 to 10^d-1,
    // d=1 a[0]=0;
    // d=2 a[1]=sum of digit from 1 to 9 = 45
    // d=3 a[2]=sum of digit from 1 to 99 = a[1]*10 + 45*10^1 = 900
    // d=4 a[3]=sum of digit from 1 to 999 = a[2]*10 + 45*10^2 = 13500
	int d=log10(N);
	long long *L = new long long[d+1];
	L[0] = 1;
	L[1] = 45;
	for(int j=2;j<=d;j++){
		L[j] = L[j-1]*10+45*ceil(pow(10,j-1));
	}
	long long p = ceil(pow(10,d));
	int msd = N/p;
	// EXPLANATION FOR FIRST and SECOND TERMS IN BELOW LINE OF CODE
    // First two terms compute sum of digits from 1 to 299
    // (sum of digits in range 1-99 stored in a[d]) +
    // (sum of digits in range 100-199, can be calculated as 1*100 + a[d]
    // (sum of digits in range 200-299, can be calculated as 2*100 + a[d]
    //  The above sum can be written as 3*a[d] + (1+2)*100
 
    // EXPLANATION FOR THIRD AND FOURTH TERMS IN BELOW LINE OF CODE
    // The last two terms compute sum of digits in number from 300 to 328
    // The third term adds 3*29 to sum as digit 3 occurs in all numbers 
    //                from 300 to 328
    // The fourth term recursively calls for 28
	return msd*L[d] + (msd*(msd-1)/2)*p + msd*(1+N%p) + sum(N%p);
}


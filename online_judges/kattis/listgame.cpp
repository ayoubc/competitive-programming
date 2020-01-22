#include <iostream>
#include<fstream>
#include <cmath>
using namespace std;
int is_prime(long p);
int main()
{
	//ifstream in("sample1.in");
	int ca=0;
    long long int n,sum,X,x;
    while(cin>>X){
    	ca++;
    	sum = 0;
    	x = X;
    	//this program is like the function that gives a factorization in simple elements of a given number
    	n = sqrt(X);
    	if(x%2==0){
        	while(x%2==0){
            	sum++;
            	x = x/2;
        	}
    	}
    	for(long i=3;i<=n;i=i+2){
        	if(x%i==0){
            	if(is_prime(i)==1){
                	while(x%i==0){
                    	sum++;
                    	x = x/i;
                	}
            	}
        	}
   	 	}
    	if(x==1){
        	cout<<"Case #"<<ca<<": "<<sum<<endl;
    	}
    	else{
        	cout<<"Case #"<<ca<<": "<<sum+1<<endl;
    	}
	}
    return 0;
}
int is_prime(long p){
    if (p==2){
        return 1;
    }
    else{
        long q = sqrt(p);
        for(long j=3;j<=q;j=j+2){
            if(p%j==0){
                return 0;
            }
        }
        return 1;
    }
}

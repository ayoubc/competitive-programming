#include<iostream>
#include <bits/stdc++.h>
using namespace std;
long collatz(long long n){
	long c=0;
	long long d=n;
	while(d>1){
		c++;
		if(d%2==0){
			//cout<<"§§§"<<endl;
			d/=2;
		}
		else{
			//cout<<"!!!"<<endl;
			d = 3*d+1;
		}
	}
	return c;
}
int main(){
	freopen("I.txt","w",stdout);
	long start=0,sequence_lengh=INT_MIN;
	for(long long s=13;s<=1000000;s++){
		cout<<"Last collatz "<<collatz(s)<<endl;
		if(sequence_lengh<=collatz(s)){
			sequence_lengh = collatz(s);
			start = s;
			cout<<s<<" "<<collatz(s)<<endl;
		}
	}
	cout<<start<<" "<<collatz(start)<<endl;
	return 0;
}


#include<iostream>
#include<sstream>
#include<fstream>
#include<vector>
#include<algorithm>
#include<string>
#include<cmath>
using namespace std;
int is_tidy(long long x);
int main(){
	ifstream in("deff.txt");
	ofstream out("deff(correct).txt");
	int T;
	long long N;
	in >> T;
	for(int i=1;i<=T;i++){
		in >> N;
		for(int j=N;j>=1;j--){
			if(is_tidy(j)==1){
				out<<"Case #"<<i<<": "<<j<<endl;
				break;
			}
		}
	}
	return 0;
}
int is_tidy(long long x){
	int d;
	d = x%10;
	x /= 10;
	while(x!=0){
		if(d>=(x%10)){
			d = x%10;
			x /= 10;
		}
		else{
			return 0;
		}
	}
	return 1;
}

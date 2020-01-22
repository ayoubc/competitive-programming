#include<iostream>
#include<sstream>
#include<fstream>
#include<vector>
#include<string>
#include<cmath>

using namespace std;

int main(){
	freopen("A-small-practice.in","r",stdin);
	freopen("A-small-practice.ans","w",stdout);
	int t,i,n;
	long long int N,newN;
	string digits;
	scanf("%d",&t);
	while(t--){
		scanf("%lld",&N);
		if(N==0){
			
			cout<<"Case #"<<100-t<<": INSOMNIA"<<endl;
		}
		else{
			digits="";
			i = 0;
			while(digits.size()<10){
				i++;
				newN = i*N;
				stringstream ss;
				string num;
				ss << newN , ss >> num;
				n = num.size();
				for(int k=0;k<n;k++){
					if(digits.find(num[k])==string::npos){
						digits += num[k];
					}
				}
			}
			cout<<"Case #"<<100-t<<": "<<newN<<endl;
		}
	}
	return 0;
}


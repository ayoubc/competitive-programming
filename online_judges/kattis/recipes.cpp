#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	//ifstream cin("i");
	int t,R,P,D,I;
	double w,p,sf,sw;
	
	cin>>t;
	for(int i=0;i<t;i++){
		cin>>R>>P>>D;
		vector<string> ing(R);
		vector<double> w(R);
		vector<double> p(R);
		for(int j=0;j<R;j++){
			cin>>ing[j]>>w[j]>>p[j];
			if(p[j]==100.0){
				I = j;
			}
		}
		sf = (double)D/(double)P;
		sw = sf*w[I];
		cout<<"Recipe # "<<i+1<<endl;
		for(int j=0;j<R;j++){
			if(j==I){
				cout<<ing[j];
				printf(" %.1f\n",sw);
			}
			else{
				cout<<ing[j];
				printf(" %.1f\n",sw*p[j]/100.0);
			}
		}
		cout<<"----------------------------------------\n";
	}
	return 0;
}


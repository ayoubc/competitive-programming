#include<iostream>
#include <bits/stdc++.h>
#include <cmath>
#define PI 3.14159265359
using namespace std;

int main(){
	//ifstream cin("i");
	double r,x,y,delta,dab,d,b,a,S,s,alpha,teta,ss;
	while(cin>>r>>x>>y){
		d = x*x+y*y;
		if(d>r*r){
			cout<<"miss\n";
		}
		else{
			if(y==0){
				dab = 2*sqrt(r*r-x*x);
				alpha = acos(dab/(2*r));
			}
			else{
				a = (-1.0)*x/y;
				b = d/y;
				
				delta = 4*a*a*b*b-4*(1+a*a)*(b*b-r*r);
				//s = sqrt(delta)*y/2;
				dab = sqrt(delta/(1+a*a));
				alpha = acos(dab/(2*r));
				//cout<<max(ss-s,S-ss+s)<<" "<<min(ss-s,S-ss+s)<<endl;
			}
			S = PI*r*r;
			s = sqrt(d)*dab/2;
			teta = PI - 2*alpha;
			ss = teta*r*r/2;
			printf("%.6f %.6f\n",max(abs(ss-s),abs(S-ss+s)),min(abs(ss-s),abs(S-ss+s)));
		}
	}
	return 0;
}


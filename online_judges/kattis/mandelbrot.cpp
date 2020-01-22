#include<iostream>
#include <bits/stdc++.h>
#include <cmath>
using namespace std;
double module(double x,double y){
	return sqrt(x*x + y*y);
}
int main(){
	//ifstream cin("i");
	double x,y,tempx,tempy,xc,yc;
	int iter = 0,cases = 0,r;
	while(cin>>xc>>yc>>r){
		iter = 1;
		cases++;
		x = xc;
		y = yc;
		while(module(x,y)<=2.0 and iter<r){
			iter++;
			tempx = x;
			tempy = y;
			x = tempx*tempx - tempy*tempy + xc;
			y = 2*tempx*tempy + yc;
		}
		
		if(module(x,y)>2.0){
			cout<<"Case "<<cases<<": OUT\n";
		}
		else{
			cout<<"Case "<<cases<<": IN\n";
		}
		//cout<<module(x,y)<<" "<<iter<<endl;
	}
	return 0;
}


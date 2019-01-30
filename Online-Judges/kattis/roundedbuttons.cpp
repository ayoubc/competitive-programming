#include<iostream>
#include <bits/stdc++.h>
using namespace std;
double X,Y,r;
double cr(double x){
	return x*x;
}
bool inR(double x1,double x2,double y1,double y2,double x,double y){
	if(x>=x1 && x<=x2 && y>=y1 && y<=y2){
		return true;
	}
	else{
		return false;
	}
}
bool inC(double xc,double yc,double x,double y){
	if(cr(x-xc)+cr(y-yc)<=r*r){
		return true;
	}
	else{
		return false;
	}
}
int main(){
	//ifstream cin("i");
	int n,m;
	double w,h,x,y;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>X>>Y>>w>>h>>r>>m;
		for(int j=0;j<m;j++){
			cin>>x>>y;
			if(inR(X+r,X+w-r,Y,Y+h,x,y) || inR(X,X+w,Y+r,Y+h-r,x,y)){
				cout<<"inside\n";
			}
			else if(inC(X+r,Y+r,x,y) || inC(X+w-r,Y+r,x,y) || inC(X+r,Y+h-r,x,y) || inC(X+w-r,Y+h-r,x,y)){
				cout<<"inside\n";
			}
			else{
				cout<<"outside\n";
			}
		}
		cout<<endl;
	}
	return 0;
}


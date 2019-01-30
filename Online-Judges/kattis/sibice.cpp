#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	//ifstream cin("i");
	int n,w,h,l;
	cin>>n>>w>>h;
	for(int i=0;i<n;i++){
		cin>>l;
		if(l*l<=w*w+h*h){
			cout<<"DA\n";
		}
		else{
			cout<<"NE\n";
		}
	}
	return 0;
}


#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	int x,y;
	cin>>x>>y;
	if(x!=0 && y==1){
		printf("IMPOSSIBLE\n");
	}
	else if(x==0 && y==1){
		printf("ALL GOOD\n");
	}
	else{
		printf("%.9f\n",(double)x/(double)(1-y));
	}
	return 0;
}


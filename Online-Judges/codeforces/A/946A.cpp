#include<bits/stdc++.h>

using namespace std;

int main(){
	// freopen("i","r",stdin);
	int n,B = 0,C = 0,x;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&x);
		if(x>=0) B += x;
		else C += x;
	}
	printf("%d\n",B-C);
}
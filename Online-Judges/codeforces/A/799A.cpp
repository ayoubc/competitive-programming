#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n,t,k,d,a,b;
	scanf("%d%d%d%d",&n,&t,&k,&d);
	a = ((n-1)/k)*t;
	puts(d<a?"YES":"NO");
	return 0;
}


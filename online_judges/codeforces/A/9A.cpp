#include <bits/stdc++.h>

using namespace std;
int gcd(int a,int b){
	if(b==0) return a;
	return gcd(b,a%b);
}
int main(){
	int y,w;
	scanf("%d %d",&w,&y);
	int s = 6 - max(w,y)+1;
	printf("%d/%d\n",s/gcd(s,6),6/gcd(s,6));
	return 0;
}


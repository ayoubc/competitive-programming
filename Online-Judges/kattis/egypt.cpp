#include <bits/stdc++.h>
using namespace std;

bool right(int a,int b,int c){
	return (b*b==a*a+c*c)||(a*a==b*b+c*c)||(c*c==a*a+b*b);
}
int main(){
//	freopen("input","r",stdin);
	int a,b,c;
	while(scanf("%d%d%d",&a,&b,&c)==3){
		if(a==0 && b==0 && c==0)
			break;
		
		printf("%s\n",(right(a,b,c)?"right":"wrong"));
	}
	return 0;
}


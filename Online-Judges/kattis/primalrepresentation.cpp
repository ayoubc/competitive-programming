#include <bits/stdc++.h>

using namespace std;
void primalRepresentation(long long n){
	int k;
	if(n<0){
		printf("-1 ");
		n *= -1;
	}
	
	for(int i=2;i<=n/i;i++){
		k = 0;
		while(n%i==0){
			k++;
			n /= i;
		}
		if(k!=0){
			if(k!=1) printf("%d^%d ",i,k);
			else printf("%d ",i);
		}
		
	}
	if(n>1) printf("%d",n);
	printf("\n");
}
int main(){
//	freopen("i.in","r",stdin);
	long long x;
	while(cin >> x){
		primalRepresentation(x);
	}
	return 0;
}


#include<stdio.h>
#include<stdlib.h>
long long a[5000001];
int n,q,i;
long long sum(int k){
	long long s = 0;
	for(;k>=1;k-=k&-k){
		s += a[k];
	}
	return s;
}
void add(int k,long long x){
	
	for(;k<=n;k+=k&-k){
		a[k] += x; 
	}
}
 int main(){
 	// freopen("i","r",stdin);
 	long long x;
 	char c;
 	scanf("%d%d",&n,&q);
 	// for(int j=1;j<=n;j++){
 	// 	a[j] = 0;
 	// }
 	while(q--){
 		scanf(" %c",&c);
 		if(c == '+'){
 			scanf("%d %lld",&i,&x);
 			add(i+1,x);
 		}
 		else{
 			scanf("%d",&i);
 			if(i==0) printf("0\n");
 			else printf("%lld\n",sum(i));
 		}
 	}
 	return 0;
 }
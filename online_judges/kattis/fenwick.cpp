#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 5000005;
ll a[N];
int n,q,i;
inline ll sum(int k){
	ll s = 0;
	for(;k>=1;k-=k&-k){
		s += a[k];
	}
	return s;
}
inline void add(int k,ll x){
	
	for(;k<=n;k+=k&-k){
		a[k] += x; 
	}
}
 int main(){
 	// freopen("i","r",stdin);
 	ll x;
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
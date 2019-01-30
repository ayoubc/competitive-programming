#include <bits/stdc++.h>

using namespace std;
const int N = 100000005;
bitset<N> bs;
void seive(){
	for(int i=2;i*i<=N;i++){
		if(bs[i]){
			for(int j=2*i;j<=N;j+=i){
				bs[j] = 0;
			}
		}
	}
}
int count(int n){
	int sum  = 0;
	for(int i=2;i<=n;i++){
		if(bs[i]) sum++;
	}
	return sum;
}
int main(){
	//freopen("i.in","r",stdin);
	bs.flip();
	seive();
	bs[1] = 0;
	int n,x,q;
	scanf("%d %d",&n,&q);
	printf("%d\n",count(n));
	while(q--){
		scanf("%d",&x);
		
		//printf("%d",bs[x]) ;
		if(bs[x]) printf("1\n");
		else printf("0\n");
	}
	return 0;
}


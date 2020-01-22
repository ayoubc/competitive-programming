#include <bits/stdc++.h>
using namespace std;
const int N = 2000001;
int D[N],P[N];
bool prime[N];

void run(){
	for(int i=1;i<N;i++) D[i] = 1;
	for(int i=2;i<N;i++){
		prime[i] = true;
		for(int j=i;j<N;j+=i){
			D[j] ++;
		}
	}
	for(int i=2;i<N;i++){
		if(prime[i]){
			P[i] = 1;
			for(int j=2*i;j<N;j+=i){
				prime[j] = false;
				P[j] ++;
			}
		}
	}
}
int main(){
	//freopen("i.txt","r",stdin);
	int q,n;
	scanf("%d",&q);
	run();
	while(q--){
		scanf("%d",&n);
		printf("%d\n",D[n] - P[n]);
	}
	return 0;
}


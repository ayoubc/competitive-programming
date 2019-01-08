#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

bool perfect(ll x){
	int sum = 0;
	while(x>0){
		sum += x%10;
		x /= 10;
	}
	return sum==10;
}
int main(){
	int k,cnt;
	scanf("%d",&k);
	ll x = 18;
	cnt = 0;
	while(cnt!=k){
		if(perfect(x)){
			cnt++;
		}
		x++;
	}
	printf("%I64d\n",x-1);
	return 0;
}


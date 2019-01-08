#include <bits/stdc++.h>

using namespace std;
bool k_good(int x,int k){
	int d;
	vector<int> ok(10,0);
	while(x){
		d = x%10;
		ok[d] = 1;
		x /= 10;
	}
	for(int i=0;i<=k;i++){
		if(!ok[i])
			return false;
	}
	return true;
}
int main(){
	//freopen("inp.in","r",stdin);
	int n,k,a,cnt = 0;
	scanf("%d%d",&n,&k);
	for(int i=0;i<n;i++){
		scanf("%d",&a);
		if(k_good(a,k))
			cnt++;
	}
	printf("%d\n",cnt);
	return 0;
}


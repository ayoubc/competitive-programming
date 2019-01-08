//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll a[15],tmp[15];
ll Max(ll a,ll  b){
	if(a<b) return b;
	return a;
}
int main(){
	//freopen("i","r",stdin);
	for(int i=0;i<14;i++){
		scanf("%I64d",&a[i]);
	}
	ll ans = 0;
	for(int i=0;i<14;i++){
	//int i = 9;
		ll cur;
		ll cnt = 0;
		ll d = a[i]/14;
		for(int j=0;j<14;j++){
			if(j==i) tmp[j] = 0;
			else tmp[j]  = a[j];
		}
		for(int j=0;j<14;j++){
			tmp[j] += d;
		}
		cur = a[i]%14;
		for(int j=i+1;j<14;j++){
			if(cur>0){
				cur--;
				tmp[j]++;
			}
		}
		for(int j=0;j<=i;j++){
			if(cur>0){
				cur--;
				tmp[j]++;
			}
		}
		for(int j=0;j<14;j++){
			if(tmp[j]%2==0) cnt+=tmp[j];
		} 
		//for(int j=0;j<14;j++) cout<<tmp[j]<<" ";
		ans = Max(ans,cnt);
	}
	printf("%I64d\n",ans);
	return 0;
}


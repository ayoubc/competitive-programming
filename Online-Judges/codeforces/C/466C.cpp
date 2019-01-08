#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
//	freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	vector<ll> a(n+1);
	vector<ll> s(n+1,0),v(n+1);
	map<ll,int> occ;
	ll ans=0;
	for(int i=1;i<=n;i++){
		scanf("%I64d",&a[i]);
		if(i==1)
			s[i] = a[i];
		else
			s[i] = s[i-1] +a[i];
		
		occ[s[i]]++;
		if(s[i]%2==0)
			v[i] = occ[s[i]/2];
	}

	for(int j=1;j<=n-1;j++){
		if(s[j]%2==0){
			ll si1 = s[j]/2;
			if(3*si1==s[n]){
				ans += v[j];
				if(s[j]==0)
					ans--;
			} 
		}
	}
	printf("%I64d\n",ans);
	return 0;
}


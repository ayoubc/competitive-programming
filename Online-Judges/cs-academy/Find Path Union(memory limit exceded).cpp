#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll,ll> pll;
int n,cnt,sz;
ll a;
int main(){
//	freopen("i.in","r",stdin);
	scanf("%d",&n);
	set<ll> st;
	cnt = 0;
	for(int i=0;i<n;i++){
		scanf("%lld",&a);
		while(a>1){
			sz = st.size();
			st.insert(a);
			if(st.size()==sz+1) cnt++;
			a /= 2;
		}
	}

	printf("%d\n",cnt);
	return 0;
}


#include <bits/stdc++.h>

using namespace std;

int main () {
//	freopen("i.txt","r",stdin);
	int t;
	scanf("%d",&t);
	while(t--){
		int n;
		scanf("%d",&n);
		vector<int> x(n), a(n);
		for(int i=0;i<n;i++) scanf("%d",&x[i]);
		for(int i=0;i<n;i++) scanf("%d",&a[i]);
		bool ok = true;
		for(int i=0;i<n-1;i++){
			if(x[i]>=x[i+1]+a[i]){
				ok = false;
				break;
			}
		}
		cout<<(ok ? "YES":"NO")<<endl;
	}
	return 0;
}


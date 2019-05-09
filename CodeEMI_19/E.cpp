#include <bits/stdc++.h>

using namespace std;

int main () {
//	freopen("i.txt","r",stdin);
	int t;
	scanf("%d",&t);
	while(t--){
		int n,m;
		set<int> s;
		scanf("%d%d",&n,&m);
		for(int i=0;i<n+m;i++) {
			int x;
			scanf("%d",&x);
			s.insert(x);
		} 
		printf("%d\n", s.size());
		for(set<int>::iterator it=s.begin(); it!=s.end(); it++) {
			printf("%d ", *it);
		}
		printf("\n");
	}
	return 0;
}


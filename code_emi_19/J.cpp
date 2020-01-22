#include <bits/stdc++.h>

using namespace std;
const int N = 100007;

int A[N];
int tree[4*N+1];
void build(int p,int s, int e){
	if(s==e){
		tree[p] = A[e];
	}
	else{
		int mid = (e+s)/2;
		build(2*p, s, mid);
		build(2*p+1, mid+1, e);
		tree[p] = min(tree[2*p], tree[2*p+1]);
	}
}
int Q(int p, int s, int e, int l, int r) {
	if(l<=s && e<=r) return tree[p];
	if(r<s || e<l) return N;
	int mid = (e+s)/2;
	return min(Q(2*p, s, mid, l, r), Q(2*p+1, mid+1, e, l, r));
}
int main () {
//	freopen("i.txt","r",stdin);
	int t;
	scanf("%d",&t);
	while(t--){
		int n,q;
		scanf("%d%d",&n,&q);
		for(int i=0;i<n;i++) scanf("%d",&A[i]);
		build(1, 0, n-1);
		while(q--) {
			int li,ri;
			scanf("%d%d",&li,&ri);
			li--, ri--;
			int mex1, mex2, ans;
			if(li==0 && ri == n-1) ans = n+1;
			else if(li != 0 && ri != n-1) {
				ans = min(Q(1, 0, n-1, 0, li-1), Q(1, 0, n-1, ri+1, n-1));
			} 
			else if(li != 0){
				ans = Q(1, 0, n-1, 0, li-1);
			}
			else{
				ans = Q(1, 0, n-1, ri+1, n-1);
			}
			printf("%d\n",ans);
		}
	}
	return 0;
}


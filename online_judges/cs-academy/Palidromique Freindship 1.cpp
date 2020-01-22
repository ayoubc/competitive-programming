#include <bits/stdc++.h>

#define mp make_pair
using namespace std;
typedef pair<int,int> pi;

long  long Min(long long a,long long b){
	return (a<=b) ? a:b;
}


int main() {
	// freopen("i.in","r",stdin);
    int n,m,u,v;
    scanf("%d %d",&n,&m);
    set<pi> F;
    for(int i=0;i<m;i++){
    	scanf("%d %d",&u,&v);
    	if(u>v) swap(u,v);
    	F.insert(mp(u,v));
    }
    int ans = 0;
    for(int i=1;i<=n;i++){
    	int l=i,r=i;
    	while(l>0 && r<=n && F.count(mp(l-1,r+1))>0){
    		l--;
    		r++;
    	}
    	ans = max(ans,r-l+1);
    }
    for(int i=1;i<=n;i++){
    	int l=i,r = i+1;
    	while(l>0 && r<=n && F.count(mp(l-1,r+1))>0){
    		l--;
    		r++;
    	}
    	ans = max(ans,r-l+1);
    }
    printf("%d\n",ans );
    return 0;
}
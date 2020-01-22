#include<bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;

int main(){
	// freopen("i","r",stdin);
	int p,n,t;
	scanf("%d",&t);
	while(t--){
		scanf("%d%d",&n,&p);
		set<pi> st;
		while(st.size()<2*n+p){
			for(int i=1;i<=n && st.size()<2*n+p;i++){
				for(int j=i+1;j<=n && st.size()<2*n+p;j++){
					if(st.count(make_pair(i,j))==0){
						st.insert(make_pair(i,j));
					}
					
				}
			}
		}
		for(set<pi>::iterator it=st.begin();it!=st.end();it++){
			pi P = *it;
			printf("%d %d\n",P.first,P.second);
		}
	}
}
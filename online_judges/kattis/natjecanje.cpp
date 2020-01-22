#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
int main(){
//	freopen("i","r",stdin);
	int n,r,s,ans,curs,mask;
	scanf("%d%d%d",&n,&s,&r);
	vector<int> R(r),S(s);
	vector<bool> K(n+1,false),HavR(n+1,false);
	for(int i=0;i<s;i++){//kayakless
		scanf("%d",&S[i]);
	}
	for(int i=0;i<r;i++){//those who have reserve
		scanf("%d",&R[i]);
		HavR[R[i]] = true;
	}
	for(int i=0;i<s;i++){//we marke those who are kayakless
		K[S[i]] = true;
	}
	ans = s;
	for(int i=0;i<r;i++){
		if(K[R[i]]){
			ans--;
			HavR[R[i]] = false;
			K[R[i]] = false;
		}
	}
	for(int i=0;i<s;i++){
		if(K[S[i]]){
			if(S[i]==1){
				if(HavR[S[i]+1]){
					ans--;
					HavR[S[i]+1] = false;
				}
			}
			else if(S[i]==n){
				if(HavR[S[i]-1]){
					ans--;
					HavR[S[i]-1] = false;
				}
			}
			else{
				if(HavR[S[i]-1]){
					ans--;
					HavR[S[i]-1] = false;
				}
				else if(HavR[S[i]+1]){
					ans--;
					HavR[S[i]+1] = false;
				}
			}
		}
	}
	printf("%d\n",ans);
	return 0;
}


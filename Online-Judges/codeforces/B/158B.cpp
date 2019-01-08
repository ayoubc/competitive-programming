#include <bits/stdc++.h>
using namespace std;
int occ[5];
int main(){
//	freopen("i","r",stdin);
	int  n;
	int x;
	occ[5] = {0};
	//for(int i=1;i<5;i++) cout<<occ[i]<<endl;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&x);
		occ[x]++;
	}
	//for(int i=1;i<5;i++) cout<<occ[i]<<endl;
	int ans = 0;
	ans += occ[4];
	ans += occ[3];
	occ[1] = (occ[1]<occ[3] ? 0:occ[1]-occ[3]);
	ans += occ[2]/2;
	occ[2] = occ[2]%2;
	if(occ[2]!=0){
		ans += occ[2];
		occ[1] = (occ[1]>=2 ? occ[1]-2 : 0);
	}
	ans += occ[1]/4;
	occ[1] = occ[1]%4;
	ans += (occ[1]!=0 ? 1:0);
	//cout<<occ[1]<<endl;
	printf("%d\n",ans);
	return 0;
}


#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n,m,c,cnt1,cnt2,cnt3,cnt4,ans;
	while(scanf("%d%d%d",&n,&m,&c)==3 && n!=0){
		cnt1=cnt2=cnt3=cnt4=0;
		if(c==1){
			for(int i=m;i>=8;i-=2)
				cnt1++;
			for(int i=n;i>=8;i-=2)
				cnt2++;
			for(int i=m-1;i>=8;i-=2)
				cnt3++;
			for(int i=n-1;i>=8;i-=2)
				cnt4++;
			ans = cnt1*cnt2 + cnt3*cnt4;
		}
		else{
			for(int i=m;i>=8;i-=2)
				cnt1++;
			for(int i=n-1;i>=8;i-=2)
				cnt2++;
			for(int i=m-1;i>=8;i-=2)
				cnt3++;
			for(int i=n;i>=8;i-=2)
				cnt4++;
			ans = cnt1*cnt2 + cnt3*cnt4;
		}
		printf("%d\n",ans);
	}
	return 0;
}


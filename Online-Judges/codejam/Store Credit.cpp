#include<bits/stdc++.h>

using namespace std;
int items[2005];
int main(){
	freopen("A-large-practice.in","r",stdin);
	freopen("A-large-practice.out","w",stdout);
	int n,c,l,index1,index2;
	scanf("%d",&n);
	for(int t=1;t<=n;t++){
		scanf("%d",&c);
		scanf("%d",&l);
		for(int i=0;i<l;i++) scanf("%d",&items[i]);
		bool found = false;
		for(int i=0;i<l;i++){
			for(int j=i+1;j<l;j++){
				if(items[j]==c - items[i]){
					index1 = i;
					index2 = j;
					found = true;
					break;
				}
			}
			if(found) break;
		}
		printf("Case #%d: %d %d\n",t,index1+1,index2+1);
	}
}
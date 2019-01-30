//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
int a[6];
int main(){
//	freopen("i","r",stdin);
	for(int i=0;i<5;i++){
		scanf("%d",&a[i]);
	}
	bool ok;
	while(1){
		for(int i=0;i<4;i++){
			if(a[i]>a[i+1]){
				swap(a[i],a[i+1]);
				for(int j=0;j<5;j++) printf("%d ",a[j]);
				cout<<"\n";
			}
		}
		ok = true;
		for(int i=0;i<5;i++){
			if(a[i]!=i+1){
				ok = false;
				break;
			}
		}
		if(ok) break;
	}
	return 0;
}


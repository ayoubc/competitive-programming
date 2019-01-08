//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
int a[100005];
int main(){
	//freopen("i.txt","r",stdin);
	int n;
	scanf("%d",&n);
	set<int> s;
	for(int i=0;i<n;i++){
		int x;
		scanf("%d",&x);
		if(x!=0) s.insert(x);
	}
	printf("%d\n",(int)s.size());
	
	return 0;
}


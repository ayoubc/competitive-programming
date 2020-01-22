#include<bits/stdc++.h>

using namespace std;
int a[101];
int main(){
	// freopen("i","r",stdin);
	int n,x;
	scanf("%d",&n);
	set<int> s;
	for(int i=0;i<n;i++){
		scanf("%d",&x);
		if(x){
			s.insert(x);
		}
	}
	printf("%d\n",s.size());

}
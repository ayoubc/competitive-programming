//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int a[N];
int search(int l,int h,int val){
	int mid,L=l,H=h;
	while(L<=H){
		mid = (L+H)/2;
		if(a[mid]==val) return mid;
		else if(a[mid]>val) H = mid-1;
		else L = mid+1;
	}
	return -1;
}
int main(){
	//freopen("i","r",stdin);
	int n,q;
	scanf("%d%d",&n,&q);
	for(int i=0;i<n;i++) scanf("%d",&a[i]);
	while(q--){
		int x;
		scanf("%d",&x);
		int index = lower_bound(a,a+n,x) - a;
		if(index==n || a[index]!=x) index = -1;
		printf("%d\n",index);
	}
	return 0;
}


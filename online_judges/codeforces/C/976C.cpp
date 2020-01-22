//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
typedef pair<pi,int> pii; 
const int N = 300005;
pii a[N];
int main(){
	//freopen("i","r",stdin);
	int n;
	int l,r;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d %d",&l,&r);
		a[i].first.first = l;
		a[i].first.second = r;
		a[i].second = i;
	}
	sort(a,a+n);
	//bool found = false;
	int I = -2,J = -2;
	for(int i=0;i<n-1;i++){
		if(a[i+1].first.first==a[i].first.first && a[i].first.second<=a[i+1].first.second){
			I = a[i].second;
			J = a[i+1].second;
			break;
		}
		else if(a[i+1].first.second <= a[i].first.second){
			I = a[i+1].second;
			J = a[i].second;
			break;
		}
	}
	printf("%d %d\n",I+1,J+1);
	return 0;
}


#include<bits/stdc++.h> 
using namespace std;
const int N = 100005;
typedef long long ll;
int a[N];
bool b[N];
int main(){
	// freopen("i","r",stdin);
	int n;
	ll ans = 0;
	scanf("%d",&n);
	for(int i=1;i<=n;i++){
		scanf("%d",&a[i]);
	}
	a[0] = 1;
	a[n+1] = 1000000;
	memset(b,false,sizeof(b));
	int i=0,j=n+1;
	while(i<j){
		while(a[i]-a[0]<=a[n+1] - a[j] && i<j){
			
			// ans = a[i]-a[0];
			i++;
		}
		while(a[i]-a[0]>=a[n+1] - a[j] && i<j){
			// a[n+1] - a[j];
			j--;
		}
	}
	// cout<<i<<" "<<j<<endl;
	// while(i>=j && i>=0){
	// 	i--;
	// }
	ans = min(a[i] - a[0],a[n+1] - a[j]);
	printf("%I64d\n",ans);
}
#include <bits/stdc++.h>

using namespace  std;
const int N = 2505;
typedef long long ll;
ll A[N];
bool nondeg(int a,int b,int c){
	return (a+b+c!=2*a) && (a+b+c!=2*b) && (a+b+c!=2*c);
}
int main(){
	// freopen("i","r",stdin);
	int n;
	unsigned int c;
	memset(A,0,sizeof(A));
	scanf("%d",&n);
	for(unsigned int a=1;a<=n;a++){
		for(unsigned int b=a;b<=n;b++){
			c = a^b;
			// c ^= c;
			// cout<< c<< endl;
			if(c>=a && c >= b && c >= 1 && c<=n){
				A[c] += nondeg(a,b,c);
			}
		}
	}
	ll ans = 0;
	for(int i=1;i<=n;i++)
		ans += A[i];
	printf("%I64d\n",ans);
}
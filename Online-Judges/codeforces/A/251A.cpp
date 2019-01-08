#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MXN = 100007;
int a[MXN];
int n,d;
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%d %d",&n,&d);
    for(int i=0;i<n;i++)scanf("%d",&a[i]);
    ll ans = 0;
    for(int i=0;i<n-1;i++){
        int *ptr = lower_bound(a+i+1,a+n,d+a[i]);
        if(ptr==a+n || *ptr!=a[i]+d) ptr--;
        ll k = (ptr - a) - i;
        ans += k*(k-1);
    }
    printf("%I64d\n",ans/2);
    return 0;
}

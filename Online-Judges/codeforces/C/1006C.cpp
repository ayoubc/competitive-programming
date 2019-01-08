#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAXN = 200007;
ll a[MAXN],L[MAXN],R[MAXN];
int n;
int bsr(ll x){
    int i = lower_bound(R,R+n,x) - R;
    return (R[i]==x ? n-1-i : -1);
}
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%I64d",&a[i]);
    }
    L[0] = a[0];
    R[n-1] = a[n-1];
    for(int i=1;i<n;i++){
        L[i] = a[i]+L[i-1];
    }
    for(int i=n-2;i>=0;i--){
        R[i] = a[i]+R[i+1];
    }
    sort(R,R+n);
    //for(int i=0;i<n;i++) cout<<R[i]<<" ";
    ll ans=0;
    for(int i=0;i<n;i++){
        int j = bsr(L[i]);
        if(j!=-1 && j>i) ans = max(ans,L[i]);
    }
    printf("%I64d\n",ans);
}

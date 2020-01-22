#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 10000007;
int b[N];
ll ans[N], BIT[N];
int n;
ll sum(int k){
    ll s= 0;
    for(;k>0;k-=k&-k){
        s += BIT[k];
    }
    return s;
}
void update(int k,int val){
    for(;k<=N;k+=k&-k){
        BIT[k] += val;
    }
}
int main(){
    //freopen("i","r",stdin);
    int t;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        for(int i=1;i<=n;i++){
            scanf("%d",&b[i]);
        }
        memset(BIT,0,sizeof(BIT));
        for(int i=n;i>=1;i--){
            ans[i] = (b[i]==1 ? 0 : sum(b[i]-1));
            update(b[i],1);
        }
        ll res=0;
        for(int i=1;i<=n;i++){
            res += ans[i];
            //res += ans[i]*(ans[i]-1)/2;
        }
        printf("%lld\n",res);
    }
    return 0;
}

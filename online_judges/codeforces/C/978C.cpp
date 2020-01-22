#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAXN = 200007;
ll a[MAXN] , pre[MAXN];
int main(){
    //freopen("i.txt","r",stdin);
    int n,m;
    scanf("%d%d",&n,&m);
    //vector<ll> a(n),pre(n,0);
    for(int i=0;i<n;i++) scanf("%I64d",&a[i]);

    pre[0] = a[0];
    for(int i=1;i<n;i++) pre[i] = a[i]+pre[i-1];
    //for(int i=0;i<n;i++) cout<<pre[i]<<" ";
    //cout<<endl;
    ll x,r;
    int f;
    for(int i=0;i<m;i++){
        scanf("%I64d",&x);
        int j = lower_bound(pre,pre+n,x) - pre;
        if(pre[j]==x) {
            f = j+1;
            r = a[j];
        }
        else{
            if(j==0){
                f = 1;
                r = x;
            }
            else{
                f = j+1;
                r = x - pre[j-1];
            }
        }
        printf("%d %I64d\n",f,r);
    }
    return 0;
}

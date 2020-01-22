#include <bits/stdc++.h>
using namespace std;

int main(){
    //freopen("i","r",stdin);
    int n,m;
    scanf("%d%d",&n,&m);
    vector<int> a(n),b(m);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    for(int i=0;i<m;i++) scanf("%d",&b[i]);
    sort(a.begin(),a.end());
    long long ans=0;
    for(int i=0;i<m;i++){
        int k = lower_bound(a.begin(),a.end(),b[i]) - a.begin();
        ans += a[k]-b[i];
    }
    printf("%lld\n",ans);
    return 0;
}

#include <bits/stdc++.h>
using namespace std;
const int N = 200007;
int a[N];
int main(){
    //freopen("i.txt","r",stdin);
    int n,m,b;
    map<int,int> mp;
    scanf("%d%d",&n,&m);
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
        mp[a[i]]++;
    }
    sort(a,a+n);
    for(int i=0;i<m;i++){
        scanf("%d",&b);
        int ans = lower_bound(a,a+n,b)-a;
        if(a[ans]==b) ans+=mp[b];
        printf("%d ",ans);
    }
    return 0;
}

#include <bits/stdc++.h>
using namespace std;
const int N = 30007;
int id[N],cnt[N];
void __init(int n){
    for(int i=1;i<=n;i++){
        id[i] = i;
        cnt[i] = 1;
    }
}
int root(int x){
    while(x!=id[x]){
        id[x] = id[id[x]];
        x = id[x];
    }
    return x;
}
void Union(int a,int b){
    int p = root(a) , q = root(b);
    if(cnt[p]<cnt[q]){
        id[p] = q;
        cnt[q] += cnt[p];
    }
    else{
        id[q] = p;
        cnt[p] += cnt[q];
    }
}
int main(){
    //freopen("i","r",stdin);
    int n,m,t,a,b;
    scanf("%d",&t);
    while(t--){
        scanf("%d%d",&n,&m);
        __init(n);
        vector<bool> vis(n+1,false);
        for(int i=0;i<m;i++){
            scanf("%d%d",&a,&b);
            if(root(a)!=root(b)){
                Union(a,b);
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            int p = root(i);
            ans = max(ans,cnt[p]);
        }
        printf("%d\n",ans);
    }
    return 0;
}

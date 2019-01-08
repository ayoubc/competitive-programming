#include <bits/stdc++.h>;
using namespace std;
int isPrime[32] = {0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1};
bool vis[18];
int perm[18];
int occ[18];
int n;
void solve(int i){
    if(i==n+1 && isPrime[perm[n]+1]){
        for(int j=1;j<=n;j++){
            if(j!=n)printf("%d ",perm[j]);
            else printf("%d\n",perm[j]);
        }
    }
    for(int j=2;j<=n;j++){
        if(!vis[j] && isPrime[j+perm[i-1]]){
            vis[j] = true;
            perm[i] = j;
            solve(i+1);
            vis[j] = false;
        }
    }
}
int main(){
    //freopen("i","r",stdin);
    //freopen("out","w",stdout);
    vector<int> v;
    while(scanf("%d",&n)==1){
        v.push_back(n);
    }
    for(int i=0;i<v.size();i++){
        perm[1] = 1;
        memset(vis,false,sizeof(vis));
        printf("Case %d:\n",i+1);
        n = v[i];
        solve(2);
        if(i!=v.size()-1) printf("\n");
    }
}

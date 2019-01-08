#include <bits/stdc++.h>

using namespace std;
int const N = 1005;
int p[N];
bool vis[N];
int main(){
    //freopen("i","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++){
        scanf("%d",&p[i]);
    }
    for(int i=1;i<=n;i++){
        memset(vis,false,sizeof(vis));
        int a = i;
        while(!vis[a]){
            vis[a] = true;
            a = p[a];
        }
        printf("%d ",a);
    }
    return 0;
}

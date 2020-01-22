#include <bits/stdc++.h>
using namespace std;
const int N = 1000007,M = 11;
int g[N],b[M],mex[M];

int main(){
    //freopen("i","r",stdin);
    int n,m;
    while(scanf("%d%d",&n,&m)==2){
        for(int i=0;i<m;i++) scanf("%d",&b[i]);
        g[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++) mex[j] = 0;
            for(int j=0;j<m;j++){
                if(i-b[j]>=0){
                    mex[g[i-b[j]]] = 1;
                }
            }
            for(int j=0;j<=m;j++){
                if(mex[j]==0){
                    g[i] = j;
                    break;
                }
            }
        }
        if(g[n]==0) printf("Ollie wins\n");
        else printf("Stan wins\n");
    }
    return 0;
}

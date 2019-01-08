#include <bits/stdc++.h>
using namespace std;
const int MXP = 21;
int G[MXP];

int main(){
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%d",&t);
    while(t--){
        int n,p,g,b;
        scanf("%d%d",&p,&n);
        for(int i=0;i<p;i++) G[i] = 0;
        for(int i=0;i<n;i++){
            scanf("%d%d",&b,&g);
            b--,g--;
            G[b] |= 1<<g;
        }
        int ans=0,cur;
        for(int i=0;i<(1<<p);i++){
            int intersect = (1<<p)-1;
            for(int j=0;j<p;j++){
                if(i&(1<<j)){
                    intersect = intersect&G[j];
                }
            }
            ans = max(ans,__builtin_popcount(intersect)+__builtin_popcount(i));
        }
        printf("%d\n",max(ans,p));
    }
    return 0;
}

#include <bits/stdc++.h>
using namespace std;
int P[13];
int main(){
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%d",&t);
    while(t--){
        int n;
        scanf("%d",&n);
        for(int i=1;i<=n;i++) P[i] = 0;
        for(int i=1;i<n;i++){
            int x;
            scanf("%d",&x);
            P[x] = 1;
        }
        int ans;
        for(int i=1;i<=n;i++){
            if(P[i]==0) {
                ans = i;
                break;
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}

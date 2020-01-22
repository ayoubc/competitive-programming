#include <bits/stdc++.h>

using namespace std;

int main(){
    //freopen("i","r",stdin);
    int n,Q,cnt=0;
    while(scanf("%d%d",&n,&Q)==2){
        if(n==0 && Q==0) break;
        cnt++;
        vector<int> mar(n);
        for(int i=0;i<n;i++) scanf("%d",&mar[i]);
        sort(mar.begin(),mar.end());
        printf("CASE# %d:\n",cnt);
        while(Q--){
            int x;
            scanf("%d",&x);
            int l = lower_bound(mar.begin(),mar.end(),x) - mar.begin();
            if(mar[l]==x) printf("%d found at %d",x,l+1);
            else printf("%d not found",x);
            printf("\n");
        }

    }
    return 0;
}

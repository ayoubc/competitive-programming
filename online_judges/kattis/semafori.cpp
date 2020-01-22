#include <bits/stdc++.h>

using namespace std;
const int N = 101;

int main(){
    int n,L,D,R,G;
    scanf("%d%d",&n,&L);
    int ans = 0;
    int dist = 0;
    for(int i=0;i<n;i++){
        scanf("%d%d%d",&D, &R, &G);
        ans += D - dist;
        dist += D-dist;
        int r = ans%(R+G);
        if(r <= R) ans += R-r;
    }
    ans += L - dist;
    printf("%d\n",ans);
    return 0;
}

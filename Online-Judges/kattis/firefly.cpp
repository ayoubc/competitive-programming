#include <bits/stdc++.h>
using namespace std;

int main(){
    //freopen("i","r",stdin);
    int n,H;
    scanf("%d%d",&n,&H);
    vector<int> F , C;
    for(int i=1;i<=n;i++){
        int x;
        scanf("%d",&x);
        if(i%2==0) C.push_back(x);
        else F.push_back(x);
    }
    sort(F.begin(),F.end());
    sort(C.begin(),C.end());
    int ans = 1e09,c,f;
    for(int h=1;h<=H;h++){
        f = lower_bound(F.begin(),F.end(),h) - F.begin();
        c = lower_bound(C.begin(),C.end(),H-h+1) - C.begin();
        ans = min(ans,n-f-c);
    }
    int cnt=0;
    for(int h=1;h<=H;h++){
        f = lower_bound(F.begin(),F.end(),h) - F.begin();
        c = lower_bound(C.begin(),C.end(),H-h+1) - C.begin();
        if(ans==n-f-c) cnt++;
    }
    printf("%d %d\n",ans,cnt);
    return 0;
}

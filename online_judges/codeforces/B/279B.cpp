#include <bits/stdc++.h>

using namespace std;
const int N = 100001;
int a[N];
int Q(int i, int j) {
    if(i==0) return a[j];
    else return a[j] - a[i-1];
}
int main() {
    //freopen("i.txt","r",stdin);
    int t,n;
    scanf("%d%d",&n,&t);
    for(int i=0;i<n;i++){
        int x;
        scanf("%d",&x);
        if(i==0) a[i] = x;
        else a[i] = a[i-1] + x;
    }
    int ans = 0;
    for(int i=0;i<n;i++){
        int l = i, r = n-1, mid;
        while(l<=r) {
            mid = (l+r) / 2;
            if(Q(i, mid)<=t) {
                ans = max(ans, mid - i + 1);
                l = mid + 1;
            }
            else r = mid - 1;
        }
        //cout<<ans<<endl;
    }
    printf("%d\n", ans);

    return 0;
}
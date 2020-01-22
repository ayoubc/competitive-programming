#include <bits/stdc++.h>

using namespace std;
const int N = 100005;
int a[N],sum[N];
int main(){
    //freopen("i","r",stdin);
    int n,m,t;
    scanf("%d",&t);
    while(t--){
        scanf("%d%d",&n,&m);
        for(int i=0;i<n;i++){
            scanf("%d",&a[i]);
            if(i==0) sum[i] = a[i];
            else sum[i] = sum[i-1]+a[i];
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(a[i]==m){
                int l=i-1,r=i+1,s;
                while(l>=0 && a[l]>m) l--;
                l++;
                while(r<n && a[r]>m) r++;
                r--;
                s = (l==0 ? sum[r] : sum[r]- sum[l-1]);
                ans = max(ans,s);
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}

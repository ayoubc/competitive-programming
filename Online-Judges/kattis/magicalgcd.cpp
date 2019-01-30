#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100007 , K = 21;
ll ST[N][K];
ll a[N];
ll gcd(ll a,ll b){
    if(b==0) return a;
    return gcd(b,a%b);
}
ll getGCD(int i,int j){
    if(i==j) return a[i];
    int x=0;
    while((1<<x)<=(j-i+1)) x++;
    x--;
    return gcd(ST[i][x] , ST[j - (1<<x)+1][x]);
}
ll Max(ll a,ll b){
    return (a>b ? a: b);
}
int main(){
    //freopen("i","r",stdin);
    int t,n;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            scanf("%lld",&a[i]);
            ST[i][0] = a[i];
        }

        for(int j=1;j<K;j++){
            for(int i=0;i+(1<<(j-1))<n;i++){
                ST[i][j] = gcd(ST[i][j-1] , ST[i+(1<<(j-1))][j-1]);
            }
        }
        ll ans = 0;
        for(int i=0;i<n;i++){
            int j=i;
            ll cur = a[i];
            while(j<n){
                int p = j;
                int q = n-1;
                while(p<q){
                    int mid = (p+q+1)/2;
                    if(getGCD(i,mid)==cur){
                        p = mid;
                    }
                    else q = mid-1;
                }
                ans = Max(ans,(p - i+1)*cur);
                j = p+1;
                if(j<n) cur = getGCD(i,j);
            }
        }
        printf("%lld\n",ans);
    }
    return 0;
}

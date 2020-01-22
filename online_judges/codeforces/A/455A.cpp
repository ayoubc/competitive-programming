#include <bits/stdc++.h>

using namespace std; 
typedef long long ll;
const int N = 100001;
int a[N];
int occ[N];
ll dp[N];

int main() {
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++) {
        scanf("%d",&a[i]);
        //cout<<a[i]<<endl;
        occ[a[i]] ++;
    }
    dp[0] = 0;
    dp[1] = occ[1];
    for(int i=2;i<N;i++){
        dp[i] = max(dp[i-1], dp[i-2] + (1LL * occ[i])*(1LL * i));
    }
    printf("%I64d\n",dp[N-1]);
    return 0;
}
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100007 , K = 17 , Q = 3*N;
int ST[N][K] , a[N], x[Q];
void __init(int n){
    for(int i=0;i<n;i++) ST[i][0] = a[i];

    for(int j=1;j<K;j++){
        for(int i=0;i+(1<<j)<=n;i++){
            ST[i][j] = __gcd(ST[i][j-1] , ST[i+(1<<(j-1))][j-1]);
        }
    }
}
int Query(int i,int j){
    int k=0;
    while((1<<k)<=j-i+1) k++;
    k--;
    return __gcd(ST[i][k] , ST[j-(1<<k)+1][k]);
}
int main(){
    //freopen("i.txt","r",stdin);
    int n,q;
    scanf("%d",&n);
    for(int i=0;i<n;i++) scanf("%d",a+i);
    scanf("%d",&q);
    for(int i=0;i<q;i++) scanf("%d",x+i);
    __init(n);
    map<int,ll> mp;
    for(int i=0;i<n;i++){
        int R=i;
        while(R<n){
            int cur = Query(i,R) ,l=R , r = n-1 , res = R ,m;
            while(l<=r){
                m = (l+r)/2;
                if(Query(i,m)==cur){
                    res = m;
                    l=m+1;
                }
                else r=m-1;
            }
            mp[cur] += res - R + 1;
            R = res+1;
        }
    }
    for(int i=0;i<q;i++){
        printf("%I64d\n",mp[x[i]]);
    }
    return 0;
}

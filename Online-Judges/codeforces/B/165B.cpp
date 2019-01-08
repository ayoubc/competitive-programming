#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
ll f(int v,int k){
    ll d,sum;
    sum = 0;
    d = 1;
    while(v/d!=0){
        sum += v/d;
        d *= k;
    }
    return sum;
}
int main(){
    int n,k;
    scanf("%d%d",&n,&k);
    int l=1,r=n,v;
    while(l<=r){
        v = (l+r)/2;
        if(f(v,k)>=n) r = v-1;
        else l = v+1;
    }
    int ans = (f(v,k)>=n ? v:v+1);
    printf("%d\n",ans);
    return 0;
}

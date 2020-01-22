#include <bits/stdc++.h>
using namespace std;
struct frac{
    int n,m;
    frac(int _n,int _m){
        n = _n;
        m = _m;
    }
    bool operator < (const frac A){
        return m * (A.n) < n * (A.m);
    }
    bool operator > (const frac A){
        return m * (A.n) > n * (A.m);
    }
};
string res;
frac target = frac(0,0);
void solve(frac a,frac b){
    frac mid = frac(a.n+b.n , a.m+b.m);
    if(mid<target) {
        res += "R";
        solve(mid,b);
    }
    else if(mid>target){
        res += "L";
        solve(a,mid);
    }
    else return;
}
int main(){
    //freopen("i","r",stdin);
    int n,m;
    while(scanf("%d%d",&m,&n)==2){
        if(n==1 && m==1) break;

        target = frac(n,m);
        res = "";
        solve(frac(1,0),frac(0,1));
        cout<<res<<endl;

    }
    return 0;
}

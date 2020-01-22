#include <bits/stdc++.h>
using namespace std;
const int MXN = 1001;
const double EPS = 1e-9;
int n,l;
int a[MXN];
bool f(double d){
    if(a[0]!=0){
        if(d<a[0]) return false;
    }
    if(a[n-1]!=l){
        if(d<l-a[n-1]) return false;
    };
    for(int i=0;i<n-1;i++){
        if(2*d<a[i+1]-a[i]) return false;
    }
    return true;
}
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%d%d",&n,&l);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    sort(a,a+n);
    double lo = 0 ,hi = l ,m,ans;
    int t=100;
    while(t--){
        m = (lo+hi)/2;
        if(f(m)){
            ans = m;
            hi = m;
        }
        else lo = m;
    }
    //cout<<(fabs(ANS-ans)<EPS ? "Correct" : "Wrong Answer")<<endl;
    printf("%.10f\n",ans);
    return 0;
}

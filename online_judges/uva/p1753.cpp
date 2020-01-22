#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const int  N = 1007;
double d[N] , s[N];
int n;
double t;
double f(double c){
    double sum = 0.0;
    for(int i=0;i<n;i++){
        sum += d[i]/(s[i]+c);
    }
    return sum;
}

int main(){
    //freopen("i","r",stdin);
    while(scanf("%d %lf",&n,&t)==2){
        double lo = -1e9 ,hi = 1e9,c;
        for(int i=0;i<n;i++){
            scanf("%lf %lf",&d[i],&s[i]);
            lo = max(lo,-s[i]);
        }
        while(hi-lo>EPS){
            c = (hi+lo)/2.0;
            double cur = f(c);
            if(cur>t) lo = c;
            else hi = c;
        }
        //cout<<f(c)<<endl;
        printf("%.9f\n",c);
    }

    return 0;
}

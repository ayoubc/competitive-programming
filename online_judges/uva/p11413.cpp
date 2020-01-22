#include <bits/stdc++.h>
using namespace std;
const int MAX = 1000000007;
int n ;
int c[1001];
int f(int cap){
    int res=1,cur=0;
    for(int i=0;i<n;i++){
        if(cur+c[i]<=cap) {
            cur += c[i];
        }
        else {
            cur = c[i];
            res++;
        }
    }
    return res;
}
int main(){
    //freopen("i.txt","r",stdin);
    int m,l,r,mid,ans;
    while(scanf("%d%d",&n,&m)==2){
        l = 0 ,r = MAX;
        for(int i=0;i<n;i++){
            scanf("%d",&c[i]);
            l = max(l,c[i]);
        }
        while(l<=r){
            mid = (l+r)/2;
            //cout<<mid<<endl;
            //cout<<f(mid)<<endl;
            if(f(mid)<=m){
                r = mid-1;
            }
            else l = mid+1;
        }
        printf("%d\n",l);
    }
    return 0;
}

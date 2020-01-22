#include <bits/stdc++.h>
using namespace std;
const int N = 1e05+7;
int a[N],t[N],pre[N];
int main(){
    //freopen("i.txt","r",stdin);
    int n,k;
    scanf("%d%d",&n,&k);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    for(int i=0;i<n;i++) scanf("%d",&t[i]);


    int res=0;
    for(int i=0;i<n;i++) {
        if(t[i]==1) {
            res+=a[i];
            a[i]=0;
        }
    }
    int cur=0;
    for(int i=0;i<n;i++) {
        if(i==0) pre[i]=a[i];
        else pre[i] = pre[i-1]+a[i];
    }
    for(int i=0;i+k-1<n;i++){
        cur = max(cur,pre[i+k-1] - (i==0 ? 0 : pre[i-1]));
    }
    printf("%d\n",cur+res);
    return 0;
}

#include <bits/stdc++.h>
using namespace std;
const int N = 100005, K = 17;
int ST[N][K] , a[N];
void __init(int n){
    for(int i=0;i<n;i++) ST[i][0] = a[i];

    for(int j=1;j<K;j++){
        for(int i=0;i+(1<<j)<=n;i++){
            ST[i][j] = min(ST[i][j-1] , ST[i+(1<<(j-1))][j-1]);
        }
    }
}
int Query(int i,int j){
    int k=0;
    if(i>j) swap(i,j);
    while((1<<k)<=j-i+1){
        k++;
    }
    k--;
    return min(ST[i][k],ST[j-(1<<k)+1][k]);
}
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    __init(n);
    int q;
    scanf("%d",&q);
    while(q--){
        int i,j;
        scanf("%d%d",&i,&j);
        printf("%d\n",Query(i,j));
    }
    return 0;
}

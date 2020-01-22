#include <bits/stdc++.h>
using namespace std;
const int N = 50007 , D = 17;
int stM[N][D],a[N];
int getM(int i,int j){
    if(i>j) swap(i,j);
    int k=0;
    while((1<<k)<=j-i+1) k++;
    k--;
    return max(stM[i][k],stM[j-(1<<k)+1][k]);
}
int main(){
    //freopen("i.txt","r",stdin);
    int n,m;
    scanf("%d%d",&n,&m);
    for(int i=0;i<n;i++) scanf("%d",a+i);
    for(int i=0;i<n;i++){
        stM[i][0] = a[i];
    }
    for(int j=1;j<D;j++){
        for(int i=0;i+(1<<j)<=n;i++){
            stM[i][j] = max(stM[i][j-1],stM[i+(1<<(j-1))][j-1]);
        }
    }
    int A,B,ans=0;
    while(m--){
        scanf("%d%d",&A,&B);
        A--,B--;
        if(B-A<2) ans++;
        if(a[A]>getM(A+1,B-1)) ans++;
    }
    printf("%d\n",ans);
    return 0;
}

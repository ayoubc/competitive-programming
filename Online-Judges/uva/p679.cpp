#include <bits/stdc++.h>
using namespace std;
const int N = (1<<20)+4 , I = 524289 , D = 21;
bool T[N];
int Q[I][D];
int d,i,l;
int f(int p,int d){
    while(2*p<(1<<d) || 2*p+1 < (1<<d)){
        if(T[p]){
            T[p] = false;
            p = 2*p+1;
        }
        else{
            T[p] = true;
            p = 2*p;
        }
    }
    return p;
}
int main(){
    //freopen("i","r",stdin);
    for(int i=2;i<D;i++){
        for(int j=1;j<(1<<i);j++) T[j] = false;
        for(int j=1;j<I;j++){
            Q[j][i] = f(1,i);
        }
    }
    scanf("%d",&l);
    while(l--){
        scanf("%d%d",&d,&i);
        printf("%d\n",Q[i][d]);
    }
    return 0;
}

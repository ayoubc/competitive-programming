#include <bits/stdc++.h>
using namespace std;
const int N = 1000007 , D = 21;
int stm[N][D],stM[N][D],a[N],Log[N];
int getM(int i,int j){
    int l = j - i + 1;
    int k = Log[l];
    return max(stM[i][k] , stM[j-(1<<k)+1][k]);
}
int getm(int i,int j){
    int l = j - i + 1;
    int k = Log[l];
    return min(stm[i][k] , stm[j-(1<<k)+1][k]);
}
int main(){
    //freopen("i","r",stdin);
    int n,m,c;
    scanf("%d%d%d",&n,&m,&c);
    for(int i=0;i<n;i++) scanf("%d",a+i);
    for(int i=0;i<n;i++){
        stm[i][0] = a[i];
        stM[i][0] = a[i];
    }
    Log[1] = 0;
    for(int i=2;i<N;i++) Log[i] = Log[i/2]+1;
    for(int j=1;j<D;j++){
        for(int i=0;i+(1<<(j-1))<n;i++){
            stm[i][j] = min(stm[i][j-1] , stm[i+(1<<(j-1))][j-1]);
            stM[i][j] = max(stM[i][j-1] , stM[i+(1<<(j-1))][j-1]);
        }
    }
    vector<int> res;
    for(int i=0;i<n-m+1;i++){
        int aM = getM(i,i+m-1) , am = getm(i,i+m-1);
        if(aM - am <= c) res.push_back(i+1);
    }
    if(res.empty()) printf("NONE\n");
    else {
        for(int i=0;i<res.size();i++) printf("%d\n",res[i]);
    }
    return 0;
}

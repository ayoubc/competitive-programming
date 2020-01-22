#include <bits/stdc++.h>
using namespace std;
const int N = 10005 , OO = 1e09;
int a[N],mem[N];
bool comp[N];
int f(int i){
    if(i==0) return a[i];
    if(mem[i]!=-OO) return mem[i];

    int res = max(a[i],a[i]+f(i-1));
    //comp[i] = true;
    return mem[i]=res;
}
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    int cnt = 1;
    while(scanf("%d",&n)==1 && n!=0){
        /*if(cnt!=1) printf("\n");
        cnt++;*/
        for(int i=0;i<n;i++) scanf("%d",&a[i]);
        for(int i=0;i<n;i++) mem[i] = -OO;
        //memset(comp,false,sizeof(comp));
        int  ans = -OO;
        for(int i=0;i<n;i++){
            ans = max(ans,f(i));
            //cout<<f(i)<<" ";
        }
         //cout<<endl;
        if(ans<=0) printf("Losing streak.\n");
        else printf("The maximum winning streak is %d.\n",ans);
    }
    return 0;
}

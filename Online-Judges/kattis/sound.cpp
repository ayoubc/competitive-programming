#include <bits/stdc++.h>

using namespace std;
const int N = 1000002 , OO = 1000000007;
int a[N];
int Tm[4*N],TM[4*N];

void build(int p,int s,int e){
    if(s==e){
        Tm[p] = a[s];
        TM[p] = a[s];
    }
    else{
        int mid = (s+e)/2;
        build(2*p,s,mid);
        build(2*p+1,mid+1,e);

        Tm[p] = min(Tm[2*p],Tm[2*p+1]);
        TM[p] = max(TM[2*p],TM[2*p+1]);
    }
}
int querym(int p,int s,int e,int a,int b){
    if(s>=a && e<=b) return Tm[p];
    if(s>b || e<a) return OO;

    int mid = (s+e)/2;
    return min(querym(2*p,s,mid,a,b),querym(2*p+1,mid+1,e,a,b));
}
int queryM(int p,int s,int e,int a,int b){
    if(s>=a && e<=b) return TM[p];
    if(s>b || e<a) return -OO;

    int mid = (s+e)/2;
    return max(queryM(2*p,s,mid,a,b),queryM(2*p+1,mid+1,e,a,b));
}
int main(){
    //freopen("i","r",stdin);
    int n,m,c;
    scanf("%d%d%d",&n,&m,&c);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    build(1,0,n-1);
    //cout<<queryM(1,0,n-1,0,n-1);
    vector<int> ans;
    for(int i=0;i<n-m+1;i++){
        int aM = queryM(1,0,n-1,i,i+m-1) , am = querym(1,0,n-1,i,i+m-1);
        if(aM - am <= c) ans.push_back(i+1);
    }
    if(ans.size()==0) printf("NONE\n");
    else for(int i=0;i<ans.size();i++) printf("%d\n",ans[i]);
    return 0;
}

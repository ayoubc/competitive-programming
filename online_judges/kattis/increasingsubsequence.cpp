#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
const int N = 207;
int a[N];
vector<int> LIS(int n){
    vector<vi> L(n,vi());
    for(int i=0;i<n;i++){
        int l=0;
        for(int j=0;j<i;j++){
            int sz = L[j].size();
            if(L[j][sz-1]<a[i]) l = max(l,sz);
        }
        vector<vi> cur;
        for(int j=0;j<i;j++){
            int sz = L[j].size();
            if(L[j][sz-1]<a[i] && sz==l) cur.push_back(L[j]);
        }
        if(cur.size()>=1){
            sort(cur.begin(),cur.end());
            for(int k=0;k<cur[0].size();k++) L[i].push_back(cur[0][k]);
        }
        L[i].push_back(a[i]);
    }
    /*for(int i=0;i<n;i++){
        cout<<i<<" : ";
        for(int j=0;j<L[i].size();j++) cout<<L[i][j]<<" ";
        cout<<endl;
    }*/
    sort(L.begin(),L.end());
    int sz = 0;
    for(int i=0;i<n;i++){
        sz = max((int)L[i].size(),sz);
    }
    int i;
    for(int k=0;k<n;k++){
        if(L[k].size()==sz){
            i = k;
            break;
        }
    }
    return L[i];
}
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    while(scanf("%d",&n)==1){
        if(n==0) break;
        for(int i=0;i<n;i++) scanf("%d",&a[i]);
        //for(int i=0;i<n;i++) printf("%d ",a[i]);
        vector<int> ans = LIS(n);
        int sz = ans.size();
        printf("%d ",sz);
        for(int i=0;i<sz;i++) printf("%d ",ans[i]);
        printf("\n");
    }
    return 0;
}

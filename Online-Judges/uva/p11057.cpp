#include <bits/stdc++.h>
using namespace std;

int main(){
    //freopen("i.txt","r",stdin);
    int n,m;
    while(scanf("%d",&n)==1){
        vector<int> v(n);
        for(int i=0;i<n;i++) scanf("%d",&v[i]);
        int I,J,diff=1e09;
        scanf("%d",&m);
        sort(v.begin(),v.end());
        for(int i=0;i<n;i++){
            int k = lower_bound(v.begin(),v.end(),m-v[i]) - v.begin();
            if(k!=n && v[k]+v[i]==m && v[i]<=v[k]){
                if(diff>=v[k] - v[i]){
                    I = v[i];
                    J = v[k];
                    diff = v[k] - v[i];
                }
            }
        }
        printf("Peter should buy books whose prices are %d and %d.\n\n",I,J);
    }
    return 0;
}

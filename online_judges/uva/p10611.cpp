#include <bits/stdc++.h>

using namespace std;
const int N = 50007;

int main(){
    freopen("i","r",stdin);

    int n,Q;
    scanf("%d",&n);
    vector<int> h(n);
    for(int i=0;i<n;i++) scanf("%d",&h[i]);
    cout<<upper_bound(h.begin(),h.end(),4)-lower_bound(h.begin(),h.end(),4)<<endl;
    scanf("%d",&Q);
    for(int i=0;i<Q;i++){
        int H;
        scanf("%d",&H);
        //vector<int> ::iterator l,u;
        int l = lower_bound(h.begin(),h.end(),H) - h.begin();
        int u = upper_bound(h.begin(),h.end(),H) - h.begin();
        //cout<<H<<" "<<l<<" "<<u<<endl;
        if(l==0) printf("X ");
        else printf("%d ",h[l-1]);
        if(u==n) printf("X\n");
        else printf("%d\n",h[u]);

    }

    return 0;
}

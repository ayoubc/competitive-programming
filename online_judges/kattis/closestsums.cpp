#include <bits/stdc++.h>

using namespace std;
int solve(vector<int> v, int x) {
    int delta = 1e09 + 7;
    int ans = x;
    for(int i=0;i<v.size();i++){
        if(delta >= abs(v[i]-x)){
            ans = v[i];
            delta = abs(v[i]-x);
        }
    }
    return ans;
}
int main () {
    //freopen("i.txt","r",stdin);
    int n;
    int m;
    int tc = 1;
    while(scanf("%d",&n)==1){
        vector<int> v(n);
        for(int i=0;i<n;i++){
            scanf("%d",&v[i]);
        }
        scanf("%d",&m);
        vector<int> V;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                V.push_back(v[i]+v[j]);
            }
        }
        printf("Case %d:\n",tc);
        while(m--){
            int x;
            scanf("%d",&x);
            printf("Closest sum to %d is %d.\n", x, solve(V,x));
        }
        tc++;
    }
    return 0;
}

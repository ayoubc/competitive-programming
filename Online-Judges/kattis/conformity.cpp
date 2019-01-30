#include <bits/stdc++.h>

using namespace std;

typedef vector<int> vi;
int main(){
    //freopen("i","r",stdin);
    int n;
    while(scanf("%d",&n)==1){
        if(n==0) break;
        map<vi,int> mp;
        vector<vi> f(n,vi());
        int mostPop = 0;
        for(int i=0;i<n;i++){
            //vector<int> v;
            for(int j=0;j<5;j++){
                int x;
                scanf("%d",&x);
                f[i].push_back(x);
            }
            sort(f[i].begin(),f[i].end());
            mp[f[i]]++;
            mostPop = max(mostPop,mp[f[i]]);
        }
        int ans = 0;
        //map<vector<int>,int> ::iterator it;
        for(int i=0;i<n;i++){
            if(mp[f[i]]==mostPop) ans++;
        }

        printf("%d\n",ans);
    }
    return 0;
}

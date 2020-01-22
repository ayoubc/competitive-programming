#include <bits/stdc++.h>

using namespace std;

int main(){
    //freopen("i","r",stdin);
    int n,m;
    while(cin >> n >> m){
        if(n==0 && m==0) break;
        map<int,int> mp;
        int x;
        for(int i=0;i<n;i++){
            scanf("%d",&x);
            mp[x]++;
        }
        for(int i=0;i<m;i++){
            int x;
            scanf("%d",&x);
            mp[x]++;
        }
        map<int,int>::iterator it;
        int ans = 0;
        for(it=mp.begin();it!=mp.end();it++){
            if(it->second==2) ans++;
        }
        printf("%d\n",ans);
    }
    return 0;
}

#include <bits/stdc++.h>
using namespace std;
const int N = 5007;

int a[N];
bool vis[N];
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    map<int,int> mp;
    for(int i=0;i<n;i++){
        int x;
        scanf("%d",&x);
        mp[x]++;
    }

    int cnt=0;
    for(map<int,int>::iterator it=mp.begin();it!=mp.end();it++){
        cnt = max(cnt,it->second);
    }
    printf("%d",cnt);
    return 0;
}
